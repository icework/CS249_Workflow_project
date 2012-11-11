package org.cloudbus.cloudsim.network.datacenter;

import java.util.List;

import org.cloudbus.cloudsim.UtilizationModel;
import org.cloudbus.cloudsim.UtilizationModelFull;
import org.cloudbus.cloudsim.core.CloudSim;


public class PSOWorkflow extends AppCloudlet {

	public PSOWorkflow(int type, int appID, double deadline, int numbervm, int userId) {
		super(type, appID, deadline, numbervm, userId);
		exeTime = 100;

	}

	@Override
	public void createCloudletList2(double[][] workflowDataTransferMap, 
			double[] workflowExecutionMI, List<Integer> vmIdList) 
	{
		long fileSize = NetworkConstants.FILE_SIZE;
		long outputSize = NetworkConstants.OUTPUT_SIZE;
		int memory = 100;
		int pesNumber = 1;
		UtilizationModel utilizationModel = new UtilizationModelFull();
		int cloudletNum = workflowExecutionMI.length;
		NetworkConstants.currentCloudletId = 0;
		
		for (int i = 0; i < cloudletNum; i++)
		{
			NetworkCloudlet cl = new NetworkCloudlet(
					NetworkConstants.currentCloudletId,
					(long) workflowExecutionMI[i],
					pesNumber,
					fileSize,
					outputSize,
					memory,
					utilizationModel,
					utilizationModel,
					utilizationModel);
			NetworkConstants.currentCloudletId++;
			cl.setUserId(userId);
			cl.submittime = CloudSim.clock();
			cl.currStagenum = -1;
			cl.setVmId(vmIdList.get(i));
			cl.numStage = 0;
			boolean receiveFlag = false;
			boolean sendFlag = false;
			//set receive
			for (int j = 0; j < cloudletNum; j++)
			{
				 if (workflowDataTransferMap[j][i] > 0)
				 {
					 cl.stages.add(new TaskStage(NetworkConstants.WAIT_RECV, workflowDataTransferMap[j][i], 0, 0, memory, vmIdList.get(j), j));
					 receiveFlag = true;
				 }
			}
			
			//set execution
			cl.stages.add(new TaskStage(NetworkConstants.EXECUTION, 0, workflowExecutionMI[i] / NetDatacenterBroker.mips[vmIdList.get(i)], 0, memory, vmIdList.get(i), i));
			
			//set send
			for (int j = 0; j < cloudletNum; j++)
			{
				 if (workflowDataTransferMap[i][j] > 0)
				 {
					 cl.stages.add(new TaskStage(NetworkConstants.WAIT_SEND, workflowDataTransferMap[i][j], 0, 0, memory, vmIdList.get(j), j));
					 sendFlag = true;
				 }
			}
			
			if (receiveFlag && sendFlag)
			{
				cl.numStage = 3;
			}
			else if (receiveFlag || sendFlag)
			{
				cl.numStage = 2;
			}
			else
			{
				cl.numStage = 1;
			}
			clist.add(cl);
		}

	}
}