
package org.cloudbus.cloudsim.network.datacenter;

import java.util.List;

import org.cloudbus.cloudsim.UtilizationModel;
import org.cloudbus.cloudsim.UtilizationModelFull;
import org.cloudbus.cloudsim.core.CloudSim;




public class ExampleWorkflow extends AppCloudlet {
	public ExampleWorkflow(int type, int appID, double deadline, int numbervm, int userId){
		super(type, appID, deadline, numbervm, userId);
		exeTime = 100;
		this.numbervm = numbervm;
	}

	public void createCloudletList(List<Integer> vmIdList){
		long length = 1000;
		long fileSize = NetworkConstants.FILE_SIZE;
		long outputSize = NetworkConstants.OUTPUT_SIZE;
		int memory = 100;
		UtilizationModel utilizationModel = new UtilizationModelFull();
		int i = 0;
		// task1
		NetworkCloudlet task1 = new NetworkCloudlet(
				NetworkConstants.currentCloudletId,
				length,
				1,
				fileSize,
				outputSize,
				memory,
				utilizationModel,
				utilizationModel,
				utilizationModel);
		task1.numStage = 2;
		NetworkConstants.currentCloudletId++;
		task1.setUserId(userId);
		task1.submittime = CloudSim.clock();
		task1.currStagenum = -1;
		task1.setVmId(vmIdList.get(i));

		// first stage: big computation
		task1.stages.add(new TaskStage(NetworkConstants.EXECUTION, 0, 1000 * 0.6, 0, memory, vmIdList.get(i), task1
				.getCloudletId()));
		task1.stages.add(new TaskStage(NetworkConstants.WAIT_SEND, 1000 * 0.6, 1000 * 0.6, 1, memory, vmIdList.get(1), task1
				.getCloudletId() + 1));
		task1.stages.add(new TaskStage(NetworkConstants.WAIT_SEND, 1000 * 0.7, 1000 * 0.7, 1, memory, vmIdList.get(2), task1
				.getCloudletId() + 2));
		task1.stages.add(new TaskStage(NetworkConstants.WAIT_SEND, 1000 * 0.8, 1000 * 0.8, 1, memory, vmIdList.get(3), task1
				.getCloudletId() + 3));
		clist.add(task1);
		i++;

		//task2
		NetworkCloudlet task2 = new NetworkCloudlet(
				NetworkConstants.currentCloudletId,
				length,
				1,
				fileSize,
				outputSize,
				memory,
				utilizationModel,
				utilizationModel,
				utilizationModel);
		task2.numStage = 3;
		NetworkConstants.currentCloudletId++;
		task2.setUserId(userId);
		task2.submittime = CloudSim.clock();
		task2.currStagenum = -1;
		task2.setVmId(vmIdList.get(i));
		task2.stages.add(new TaskStage(NetworkConstants.WAIT_RECV, 1000 * 0.6, 1000 * 0.6, 0, memory, vmIdList.get(0), task2
				.getCloudletId() - 1));
		task2.stages.add(new TaskStage(
				NetworkConstants.EXECUTION,
				0,
				1000 * 0.7,
				0,
				memory,
				vmIdList.get(i),
				task2.getCloudletId()));
		task2.stages.add(new TaskStage(NetworkConstants.WAIT_SEND, 1000 * 0.6, 1000 * 0.6, 1, memory, vmIdList.get(4), task2
				.getCloudletId() + 3));
		clist.add(task2);
		i++;

		//taks3
		NetworkCloudlet task3 = new NetworkCloudlet(
				NetworkConstants.currentCloudletId,
				length,
				1,
				fileSize,
				outputSize,
				memory,
				utilizationModel,
				utilizationModel,
				utilizationModel);
		task3.numStage = 3;
		NetworkConstants.currentCloudletId++;
		task3.setUserId(userId);
		task3.submittime = CloudSim.clock();
		task3.currStagenum = -1;
		task3.setVmId(vmIdList.get(i));
		task3.stages.add(new TaskStage(NetworkConstants.WAIT_RECV, 1000 * 0.7, 1000 * 0.7, 0, memory, vmIdList.get(0), task3
				.getCloudletId() - 2));
		task3.stages.add(new TaskStage(
				NetworkConstants.EXECUTION,
				0,
				1000 * 0.8,
				0,
				memory,
				vmIdList.get(i),
				task3.getCloudletId()));
		task3.stages.add(new TaskStage(NetworkConstants.WAIT_SEND, 1000 * 0.7, 1000 * 0.7, 1, memory, vmIdList.get(4), task3
				.getCloudletId() + 2));
		clist.add(task3);
		i++;

		//task4

		NetworkCloudlet task4 = new NetworkCloudlet(
				NetworkConstants.currentCloudletId,
				length,
				1,
				fileSize,
				outputSize,
				memory,
				utilizationModel,
				utilizationModel,
				utilizationModel);
		task4.numStage = 3;
		NetworkConstants.currentCloudletId++;
		task4.setUserId(userId);
		task4.submittime = CloudSim.clock();
		task4.currStagenum = -1;
		task4.setVmId(vmIdList.get(i));
		task4.stages.add(new TaskStage(NetworkConstants.WAIT_RECV, 1000 * 0.8, 1000 * 0.8, 0, memory, vmIdList.get(0), task4
				.getCloudletId()-3));
		task4.stages.add(new TaskStage(
				NetworkConstants.EXECUTION,
				0,
				1000 * 0.9,
				0,
				memory,
				vmIdList.get(i),
				task4.getCloudletId()));
		task4.stages.add(new TaskStage(NetworkConstants.WAIT_SEND, 1000 * 0.8, 1000 * 0.8, 1, memory, vmIdList.get(4), task4
				.getCloudletId() + 1));
		clist.add(task4);
		i++;

		//task5
		NetworkCloudlet task5 = new NetworkCloudlet(
				NetworkConstants.currentCloudletId,
				length,
				1,
				fileSize,
				outputSize,
				memory,
				utilizationModel,
				utilizationModel,
				utilizationModel);
		task5.numStage = 2;
		NetworkConstants.currentCloudletId++;
		task5.setUserId(userId);
		task5.submittime = CloudSim.clock();
		task5.currStagenum = -1;
		task5.setVmId(vmIdList.get(i));
		task5.stages.add(new TaskStage(NetworkConstants.WAIT_RECV, 1000 * 0.6, 1000 * 0.6, 1, memory, vmIdList.get(1), task2
				.getCloudletId()));
		task5.stages.add(new TaskStage(NetworkConstants.WAIT_RECV, 1000 * 0.7, 1000 * 0.7, 1, memory, vmIdList.get(2), task3
				.getCloudletId()));
		task5.stages.add(new TaskStage(NetworkConstants.WAIT_RECV, 1000 * 0.8, 1000 * 0.8, 0, memory, vmIdList.get(3), task4
				.getCloudletId()));
		task5.stages.add(new TaskStage(
				NetworkConstants.EXECUTION,
				0,
				1000 * 1,
				1,
				memory,
				vmIdList.get(i),
				task5.getCloudletId()));
		
		clist.add(task5);
		i++;
	}
}