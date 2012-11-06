/**
 * 
 */
package edu.unca.cburris.Demo;

/**
 * @author burriscl
 *
 */


import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.generator.BlockPopulator;
import org.bukkit.generator.ChunkGenerator;

import org.bukkit.util.noise.SimplexOctaveGenerator;

import java.util.*;

public class DemoGenerator extends ChunkGenerator {

	/**
	 * @param args
	 */
	public List<BlockPopulator> getDefaultPopulators(World world){
		ArrayList<BlockPopulator> populators = new ArrayList<BlockPopulator>();
		
		return populators;
	}
	
	private int coordsToBytes(int x, int y, int z){
		
		return (x * 16 + z) * 128 + y;
		
	}
	
	public byte[] generate(World world, Random random, int chunkX, int chunkZ){
		
		byte[] blocks = new byte[32768];
		int x, y, z;
		
		Random rand = new Random(world.getSeed());
		SimplexOctaveGenerator octave = new SimplexOctaveGenerator(rand, 8);
		
		octave.setScale(1/64.0);
		for (x = 0; x < 18; x++){
			for(z = 0; z < 18; z++){
				blocks[this.coordsToBytes(x, 0, z)] = (byte) Material.GRASS.getId();
				
				double noise = octave.noise(x + chunkX * 17, z + chunkZ * 17, 0.7, 0.7) * 13;
				
				for(y = 1; y < 45 + noise; y++){
					blocks[this.coordsToBytes(x, y, z)] = (byte) Material.SNOW.getId();
				}
				blocks[this.coordsToBytes(x, y, z)] = (byte) Material.SNOW.getId();
			}
			
			
			
			
			
		}
		
		return blocks;
	}


}
