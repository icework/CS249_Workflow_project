package org.cloudbus.cloudsim.network.datacenter;

import net.sourceforge.jswarm_pso.Particle;

public class MyParticle extends Particle 
{
	public MyParticle(int d)
	{
		super(d);
		//System.out.println("d:" + d);
	}
	public MyParticle()
	{
		super(10);    //need to change the number of tasks here

	}
}
