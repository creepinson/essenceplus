package me.creepinson.main;


import java.util.Random;

import me.creepinson.entities.Creepino;
import me.creepinson.entities.Creepino.EntityArrowCustom;
import me.creepinson.events.EventHandlerMOD;
import me.creepinson.handlers.MobDropsHandler;
import me.creepinson.item.mcreator_bullet;
import me.creepinson.lib.RefStrings;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.IFuelHandler;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;


@net.minecraftforge.fml.common.Mod(modid = me.creepinson.lib.RefStrings.MODID, version =  me.creepinson.lib.RefStrings.VERSION)
public class Main  implements IFuelHandler, IWorldGenerator{
	
	@Mod.Instance(RefStrings.MODID)
	public static Main instance;
	
	@SidedProxy(clientSide = "me.creepinson.main.ClientProxy", serverSide = "me.creepinson.main.CommonProxy")  
	public static CommonProxy proxy;

	
	//VARIABLES

	
public static Creepino mcreator_0 = new Creepino();
public static mcreator_bullet mcreator_1 = new mcreator_bullet();



@EventHandler
public void severStarting(FMLServerStartingEvent event)
{
	mcreator_0.serverLoad(event);
	mcreator_1.serverLoad(event);


}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {

		chunkX = chunkX * 16;
		chunkZ = chunkZ * 16;
		if (world.provider.getDimension() == -1)
			mcreator_0.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == 0)
			mcreator_0.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == -1)
			mcreator_1.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == 0)
			mcreator_1.generateSurface(world, random, chunkX, chunkZ);

	}
@Override
public int getBurnTime(ItemStack fuel) {
	if (mcreator_0.addFuel(fuel) != 0)
		return mcreator_0.addFuel(fuel);
	if (mcreator_1.addFuel(fuel) != 0)
		return mcreator_1.addFuel(fuel);
	return 0;
}


	

    //INITS
    @net.minecraftforge.fml.common.Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
       	mcreator_0.instance = this.instance;
    		mcreator_1.instance = this.instance;
    		mcreator_0.preInit(event);
    		mcreator_1.preInit(event);

    		ResourceLocation sound0 = new ResourceLocation("meepersplus", "creepinoDeath");
    		GameRegistry.register(new net.minecraft.util.SoundEvent(sound0).setRegistryName(sound0));

    		ResourceLocation sound1 = new ResourceLocation("meepersplus", "creepinoHurt");
    		GameRegistry.register(new net.minecraft.util.SoundEvent(sound1).setRegistryName(sound1));

    		ResourceLocation sound2 = new ResourceLocation("meepersplus", "creepinoScreech");
    		GameRegistry.register(new net.minecraft.util.SoundEvent(sound2).setRegistryName(sound2));

        	registerEntity(Creepino.EntitysheepGunner.class, "Creepino", 0, (0 << 16) + (255 << 8) + 51, (204 << 16) + (0 << 8) + 0);
        registerEntityNoEgg(EntityArrowCustom.class, "entityBullet", 1);
		proxy.preInit();
     
    }
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	GameRegistry.registerFuelHandler(this);
		GameRegistry.registerWorldGenerator(this, 1);
		if (event.getSide() == Side.CLIENT) {
			OBJLoader.INSTANCE.addDomain("meepersplus");
		}
		mcreator_0.load(event);
		mcreator_1.load(event);
		proxy.registerRenderers(this);

		
		proxy.init();
    	MinecraftForge.EVENT_BUS.register(new EventHandlerMOD());
    	MinecraftForge.EVENT_BUS.register(new MobDropsHandler());
    
    	
    }
    @EventHandler
    public void postInit(FMLPostInitializationEvent PostEvent)
    {
		
		proxy.postInit();	
    	
    }
	
    public static void registerEntity(Class entityClass, String name, int ID, int color1, int color2){
        
        
    long seed = name.hashCode();
    Random rand = new Random(seed);
    int primaryColor = rand.nextInt() * 16777215;
    int secondaryColor = rand.nextInt() * 16777215;

    EntityRegistry.registerModEntity(entityClass, name, ID, instance, 64, 10, true, color1, color2);
    }
    public static void registerEntityNoEgg(Class entityClass, String name, int ID){
        
        
        long seed = name.hashCode();
        Random rand = new Random(seed);
        int primaryColor = rand.nextInt() * 16777215;
        int secondaryColor = rand.nextInt() * 16777215;

        EntityRegistry.registerModEntity(entityClass, name, ID, instance, 64, 10, true);

        }
    
    
    
}
