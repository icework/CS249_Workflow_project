package org.cloudbus.cloudsim.network.datacenter;

import java.util.Iterator;
import java.util.List;

import net.sourceforge.jswarm_pso.Neighborhood;
import net.sourceforge.jswarm_pso.Neighborhood1D;
import net.sourceforge.jswarm_pso.Swarm;
import net.sourceforge.jswarm_pso.example_2.SwarmShow2D;
import org.cloudbus.cloudsim.Datacenter;
import org.cloudbus.cloudsim.Vm;

public class PSO {

	public PSO(double[][] td, double[] et){
		workFlowDataTrans = td;
		workFlowTaskExcution = et;
	}
	
	
	public int[] runPSO(){
		// Create a swarm (using 'MyParticle' as sample particle and 'MyFitnessFunction' as fitness function)
		Swarm swarm = new Swarm(Swarm.DEFAULT_NUMBER_OF_PARTICLES, new MyParticle(workFlowTaskExcution.length), new MyFitnessFunction(workFlowDataTrans, workFlowTaskExcution, vmData, vmTransferCost));
		// Use neighborhood
		Neighborhood neigh = new Neighborhood1D(Swarm.DEFAULT_NUMBER_OF_PARTICLES / 5, true);
		swarm.setNeighborhood(neigh);
		swarm.setNeighborhoodIncrement(0.9);
		
		// Tune swarm's update parameters (if needed)
		swarm.setInertia(0.95);
		swarm.setParticleIncrement(0.8);
		swarm.setGlobalIncrement(0.8);
		
		// Set position (and velocity) constraints. I.e.: where to look for solutions
		swarm.setInertia(0.95);
		swarm.setMaxPosition(workFlowTaskExcution.length);
		swarm.setMinPosition(0);
		swarm.setMaxMinVelocity(0.1);
		
		int numberOfIterations = 100;
		boolean showGraphics = false;
		
		if (showGraphics) {
			int displayEvery = numberOfIterations / 100 + 1;
			SwarmShow2D ss2d = new SwarmShow2D(swarm, numberOfIterations, displayEvery, true);
			ss2d.run();
		} else {
			// Optimize (and time it)
			for (int i = 0; i < numberOfIterations; i++)
				swarm.evolve();
		}
		
		// transfer double to int
		double[] bestPosition = swarm.getBestPosition();
		int[] intBestPosition = new int[bestPosition.length];
		for(int i = 0; i < bestPosition.length; i++ )
		{
			intBestPosition[i] = (int)bestPosition[i];
		}
		return intBestPosition;
	}
	
	
	
	/**
	 * Get VM information(MIPS, execution cost, bandwidth cost) into an array
	 */
	private void getVmData(){
	    List<Vm> vmList = datacenter.getVmList();
	    int sizeOfVm = vmList.size();
	    Iterator<Vm> it = vmList.iterator();
	    int count = 0;
	    vmData = new double[sizeOfVm][2];
	    while(it.hasNext())
	    {
	    	Vm tmp = it.next();
	    	vmData[count][0] = tmp.getMips();
	    	vmData[count][1] = tmp.getExecutionCost();
	    	vmTransferCost[count] = tmp.getBandwidthCost();
	    }
	}
	
	
	
	private double[][] vmData;
	private double[][] vmTransferCost;
	private Datacenter datacenter;
	private double[][] workFlowDataTrans;
	private double[] workFlowTaskExcution;
}
