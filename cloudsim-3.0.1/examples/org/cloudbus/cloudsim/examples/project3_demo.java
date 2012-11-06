package org.cloudbus.cloudsim.examples;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

import org.cloudbus.cloudsim.Cloudlet;
import org.cloudbus.cloudsim.DatacenterCharacteristics;
import org.cloudbus.cloudsim.Host;
import org.cloudbus.cloudsim.Log;
import org.cloudbus.cloudsim.Pe;
import org.cloudbus.cloudsim.Storage;
import org.cloudbus.cloudsim.UtilizationModel;
import org.cloudbus.cloudsim.UtilizationModelFull;
import org.cloudbus.cloudsim.VmSchedulerTimeShared;
import org.cloudbus.cloudsim.CloudletSchedulerSpaceShared;
import org.cloudbus.cloudsim.core.CloudSim;
import org.cloudbus.cloudsim.network.datacenter.NetworkCloudlet;
import org.cloudbus.cloudsim.network.datacenter.EdgeSwitch;
import org.cloudbus.cloudsim.network.datacenter.NetDatacenterBroker;
import org.cloudbus.cloudsim.network.datacenter.NetworkConstants;
import org.cloudbus.cloudsim.network.datacenter.NetworkDatacenter;
import org.cloudbus.cloudsim.network.datacenter.NetworkHost;
import org.cloudbus.cloudsim.network.datacenter.NetworkVm;
import org.cloudbus.cloudsim.network.datacenter.NetworkVmAllocationPolicy;
import org.cloudbus.cloudsim.network.datacenter.ExampleWorkflow;
import org.cloudbus.cloudsim.network.datacenter.NetworkCloudletSpaceSharedScheduler;
import org.cloudbus.cloudsim.provisioners.BwProvisionerSimple;
import org.cloudbus.cloudsim.provisioners.PeProvisionerSimple;
import org.cloudbus.cloudsim.provisioners.RamProvisionerSimple;

/**
 * A simple example showing how to create a datacenter with one host and a
 * network topology and and run one cloudlet on it.
 */
public class project3_demo {

	/** The cloudlet list. */
	private static List<NetworkCloudlet> cloudletList;

	/** The vmlist. */
	private static List<NetworkVm> vmlist;
	
	private static List<Integer> vmIdList;

	/**
	 * Creates main() to run this example
	 */
	public static void main(String[] args) {

		Log.printLine("Starting NetworkExample1...");

		try {
			// First step: Initialize the CloudSim package. It should be called
			// before creating any entities.
			int num_user = 1; // number of cloud users
			Calendar calendar = Calendar.getInstance();
			boolean trace_flag = false; // mean trace events

			// Initialize the CloudSim library
			CloudSim.init(num_user, calendar, trace_flag);

			// Second step: Create Datacenters
			// Datacenters are the resource providers in CloudSim. We need at
			// list one of them to run a CloudSim simulation
			NetworkDatacenter datacenter0 = createDatacenter("Datacenter_0");

			// Third step: Create Broker
			NetDatacenterBroker broker = createBroker();
			broker.setLinkDC(datacenter0);
			int brokerId = broker.getId();

			// Fourth step: Create one virtual machine
			/*vmlist = new ArrayList<NetworkVm>();

			// VM description

			int vmid = 0;
			int[] mipsList = { 80, 50, 10, 10, 5, 15, 20, 60 };
			int mips = 250;
			long size = 10000; // image size (MB)
			int ram = 512; // vm memory (MB)
			long bw = 1000;
			int pesNumber = 1; // number of cpus
			String vmm = "Xen"; // VMM name

			// create VM
			NetworkVm vm1 = new NetworkVm(vmid++, brokerId, mipsList[0],
					pesNumber, ram, bw, size, vmm,
					new NetworkCloudletSpaceSharedScheduler());
			NetworkVm vm2 = new NetworkVm(vmid++, brokerId, mipsList[1],
					pesNumber, ram, bw, size, vmm,
					new NetworkCloudletSpaceSharedScheduler());
			NetworkVm vm3 = new NetworkVm(vmid++, brokerId, mipsList[2],
					pesNumber, ram, bw, size, vmm,
					new NetworkCloudletSpaceSharedScheduler());
			NetworkVm vm4 = new NetworkVm(vmid++, brokerId, mipsList[3],
					pesNumber, ram, bw, size, vmm,
					new NetworkCloudletSpaceSharedScheduler());
			NetworkVm vm5 = new NetworkVm(vmid++, brokerId, mipsList[4],
					pesNumber, ram, bw, size, vmm,
					new NetworkCloudletSpaceSharedScheduler());
			NetworkVm vm6 = new NetworkVm(vmid++, brokerId, mipsList[5],
					pesNumber, ram, bw, size, vmm,
					new NetworkCloudletSpaceSharedScheduler());
			NetworkVm vm7 = new NetworkVm(vmid++, brokerId, mipsList[6],
					pesNumber, ram, bw, size, vmm,
					new NetworkCloudletSpaceSharedScheduler());
			NetworkVm vm8 = new NetworkVm(vmid++, brokerId, mipsList[7],
					pesNumber, ram, bw, size, vmm,
					new NetworkCloudletSpaceSharedScheduler());
			// add the VM to the vmList
			vmlist.add(vm1);
			vmlist.add(vm2);
			vmlist.add(vm3);
			vmlist.add(vm4);
			vmlist.add(vm5);
			vmlist.add(vm6);
			vmlist.add(vm7);
			vmlist.add(vm8);

			// submit vm list to the broker
			broker.submitVmList(vmlist);
			
			// Fifth step: Create one Cloudlet
			cloudletList = new ArrayList<NetworkCloudlet>();

			// Cloudlet properties
			int id = 0;
			long length = 40000;
			long fileSize = 300;
			long outputSize = 300;
			int memory = 100;
			UtilizationModel utilizationModel = new UtilizationModelFull();

			NetworkCloudlet cloudlet1 = new NetworkCloudlet(id, length,
					pesNumber, fileSize, outputSize, memory, utilizationModel,
					utilizationModel, utilizationModel);
			cloudlet1.setUserId(brokerId);

			// add the cloudlet to the list
			cloudletList.add(cloudlet1);

			// submit cloudlet list to the broker
			broker.submitCloudletList(cloudletList);*/
        
			/*
			//public ExampleWorkflow(int type, int appID, double deadline, int numbervm, int userId)
			ExampleWorkflow exampleWorkflow = new ExampleWorkflow(0, 0, 500, 8, 1);
			vmIdList = new ArrayList<Integer>();
			for (int i = 0; i < 8; i++)
			{
				Integer vmId = (Integer) i;
				vmIdList.add(vmId);
			}
			
			exampleWorkflow.createCloudletList(vmIdList);
			broker.submitCloudletList(exampleWorkflow.getClist());
			*/
			// Seventh step: Starts the simulation
			
			CloudSim.startSimulation();

			/*
			 * // Final step: Print results when simulation is over
			 * List<Cloudlet> newList = broker.getCloudletReceivedList();
			 */
			
			CloudSim.stopSimulation();

			List<Cloudlet> newList = broker.getCloudletReceivedList();
			printCloudletList(newList);
			System.out.println("numberofcloudlet " + newList.size() + " Cached "
					+ NetDatacenterBroker.cachedcloudlet + " Data transfered "
					+ NetworkConstants.totaldatatransfer);
			// Print the debt of each user to each datacenter
			datacenter0.printDebts();

			Log.printLine("CloudSimExample1 finished!");
		} catch (Exception e) {
			e.printStackTrace();
			Log.printLine("Unwanted errors happen");
		}
	}

	private static NetworkDatacenter createDatacenter(String name) {

		// Here are the steps needed to create a PowerDatacenter:
		// 1. We need to create a list to store
		// our machine
		List<NetworkHost> hostList = new ArrayList<NetworkHost>();

		// 2. A Machine contains one or more PEs or CPUs/Cores.
		// In this example, it will have only one core.
		List<Pe> peList = new ArrayList<Pe>();

		int mips = 1000;

		// 3. Create PEs and add these into a list.
		peList.add(new Pe(0, new PeProvisionerSimple(mips))); // need to store
																// Pe id and
																// MIPS Rating

		// 4. Create Host with its id and list of PEs and add them to the list
		// of machines
		int ram = 2048; // host memory (MB)
		long storage = 1000000; // host storage
		int bw = 10000;
		int hostNumber = 4;

		for (int index = 0; index < hostNumber; index++) {
			hostList.add(new NetworkHost(index, new RamProvisionerSimple(ram),
					new BwProvisionerSimple(bw), storage, peList,
					new VmSchedulerTimeShared(peList))); // This is our machine
		}

		
		System.out.println();
		// This is our machine

		// 5. Create a DatacenterCharacteristics object that stores the
		// properties of a data center: architecture, OS, list of
		// Machines, allocation policy: time- or space-shared, time zone
		// and its price (G$/Pe time unit).
		String arch = "x86"; // system architecture
		String os = "Linux"; // operating system
		String vmm = "Xen";
		double time_zone = 10.0; // time zone this resource located
		double cost = 3.0; // the cost of using processing in this resource
		double costPerMem = 0.05; // the cost of using memory in this resource
		double costPerStorage = 0.001; // the cost of using storage in this
										// resource
		double costPerBw = 0.0; // the cost of using bw in this resource
		LinkedList<Storage> storageList = new LinkedList<Storage>(); // we are
																		// not
																		// adding
																		// SAN
																		// devices
																		// by
																		// now

		DatacenterCharacteristics characteristics = new DatacenterCharacteristics(
				arch, os, vmm, hostList, time_zone, cost, costPerMem,
				costPerStorage, costPerBw);

		// 6. Finally, we need to create a PowerDatacenter object.
		NetworkDatacenter datacenter = null;
		try {
			datacenter = new NetworkDatacenter(name, characteristics,
					new NetworkVmAllocationPolicy(hostList), storageList, 0);

		} catch (Exception e) {
			e.printStackTrace();
		}
		// Create Internal Datacenter network
		CreateNetwork(4, datacenter);
		return datacenter;
	}

	// We strongly encourage users to develop their own broker policies, to
	// submit vms and cloudlets according
	// to the specific rules of the simulated scenario
	/**
	 * Creates the broker.
	 * 
	 * @return the datacenter broker
	 */
	private static NetDatacenterBroker createBroker() {
		NetDatacenterBroker broker = null;
		try {
			broker = new NetDatacenterBroker("Broker");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return broker;
	}

	/**
	 * Prints the Cloudlet objects
	 * 
	 * @param list
	 *            list of Cloudlets
	 */
	private static void printCloudletList(List<Cloudlet> list) {
		int size = list.size();
		Cloudlet cloudlet;

		String indent = "    ";
		Log.printLine();
		Log.printLine("========== OUTPUT ==========");
		Log.printLine("Cloudlet ID" + indent + "STATUS" + indent
				+ "Data center ID" + indent + "VM ID" + indent + "Time"
				+ indent + "Start Time" + indent + "Finish Time");

		for (int i = 0; i < size; i++) {
			cloudlet = list.get(i);
			Log.print(indent + cloudlet.getCloudletId() + indent + indent);

			if (cloudlet.getCloudletStatus() == Cloudlet.SUCCESS) {
				Log.print("SUCCESS");

				DecimalFormat dft = new DecimalFormat("###.##");
				Log.printLine(indent + indent + cloudlet.getResourceId()
						+ indent + indent + indent + cloudlet.getVmId()
						+ indent + indent
						+ dft.format(cloudlet.getActualCPUTime()) + indent
						+ indent + dft.format(cloudlet.getExecStartTime())
						+ indent + indent
						+ dft.format(cloudlet.getFinishTime()));
			}
		}

	}

	static void CreateNetwork(int numhost, NetworkDatacenter dc) {

		// Edge Switch
		EdgeSwitch edgeswitch[] = new EdgeSwitch[1];

		for (int i = 0; i < 1; i++) {
			edgeswitch[i] = new EdgeSwitch("Edge" + i,
					NetworkConstants.EDGE_LEVEL, dc);
			// edgeswitch[i].uplinkswitches.add(null);
			dc.Switchlist.put(edgeswitch[i].getId(), edgeswitch[i]);
			// aggswitch[(int)
			// (i/Constants.AggSwitchPort)].downlinkswitches.add(edgeswitch[i]);
		}

		for (Host hs : dc.getHostList()) {
			NetworkHost hs1 = (NetworkHost) hs;
			hs1.bandwidth = NetworkConstants.BandWidthEdgeHost;
			int switchnum = (int) (hs.getId() / NetworkConstants.EdgeSwitchPort);
			edgeswitch[switchnum].hostlist.put(hs.getId(), hs1);
			dc.HostToSwitchid.put(hs.getId(), edgeswitch[switchnum].getId());
			hs1.sw = edgeswitch[switchnum];
			List<NetworkHost> hslist = hs1.sw.fintimelistHost.get(0D);
			if (hslist == null) {
				hslist = new ArrayList<NetworkHost>();
				hs1.sw.fintimelistHost.put(0D, hslist);
			}
			hslist.add(hs1);

		}

	}
}
