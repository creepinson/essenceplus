package me.creepinson.entities;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;

import org.lwjgl.util.vector.Quaternion;

import me.creepinson.handlers.ItemHandler;
import me.creepinson.item.mcreator_bullet;
import me.creepinson.lib.RefStrings;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.Matrix4f;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIAttackRanged;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityTippedArrow;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SuppressWarnings("unchecked")
public class Creepino {

	public int mobid = 0;
	public static Object instance;

    public void load(FMLInitializationEvent event){
	}

    public void generateNether(World world, Random random, int chunkX, int chunkZ){}
	public void generateSurface(World world, Random random, int chunkX, int chunkZ){}
	public int addFuel(ItemStack fuel){
		return 0;
	}
	
	@SideOnly(Side.CLIENT)
	public void registerRenderers(){
		RenderLiving customRender = new RenderLiving(Minecraft.getMinecraft().getRenderManager(), new Creepino.ModelCreepino(), 0){protected ResourceLocation getEntityTexture(Entity par1Entity){return new ResourceLocation(RefStrings.MODID + ":" + "textures/entity/Creepino_tex.png");}};
		RenderingRegistry.registerEntityRenderingHandler(Creepino.EntitysheepGunner.class, customRender);
		RenderingRegistry.registerEntityRenderingHandler(EntityArrowCustom.class, new RenderSnowball(Minecraft.getMinecraft().getRenderManager(), new ItemStack(mcreator_bullet.block).getItem() ,Minecraft.getMinecraft().getRenderItem()));

	}
	
	public void serverLoad(FMLServerStartingEvent event){}
	public void preInit(FMLPreInitializationEvent event){
		int entityID = MathHelper.getRandomUUID().hashCode();
		mobid = entityID;

		EntityRegistry.addSpawn(Creepino.EntitysheepGunner.class, 20, 3, 30, EnumCreatureType.MONSTER , Biome.REGISTRY.getObject(new ResourceLocation("forest")));

        
		
		int entityID2 = MathHelper.getRandomUUID().hashCode();


	}
	
	public static Biome[] clean(net.minecraft.util.registry.RegistryNamespaced<ResourceLocation, Biome> in) {
		Iterator<Biome> itr = in.iterator();
		ArrayList<Biome> ls = new ArrayList<Biome>();
		while(itr.hasNext()){
			ls.add(itr.next());
		}
		return ls.toArray(new Biome[ls.size()]);
	}

    public static class EntityArrowCustom extends EntityTippedArrow {public EntityArrowCustom(World a) {super(a);}
public EntityArrowCustom(World worldIn, double x, double y, double z) {super(worldIn, x, y, z);}
public EntityArrowCustom(World worldIn, EntityLivingBase shooter) {super(worldIn, shooter);}}

   public static class EntitysheepGunner extends EntityMob  implements IRangedAttackMob 
	{
		World world = null;
	    public EntitysheepGunner(World var1)
	    {
	        super(var1);
	        world = var1;
	        experienceValue = 5;
	        this.isImmuneToFire = false;
	        addRandomArmor();
			setNoAI(!true);
        	this.tasks.addTask(0, new EntityAISwimming(this));
this.tasks.addTask(6, new EntityAIWander(this, 1.0D));
this.tasks.addTask(8, new EntityAILookIdle(this));
this.tasks.addTask(2, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
this.tasks.addTask(3, new EntityAIAttackMelee(this, 1.0D, false));
this.tasks.addTask(4, new EntityAILeapAtTarget(this, 0.8F));
this.targetTasks.addTask(4, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
this.targetTasks.addTask(6, new EntityAINearestAttackableTarget(this, EntityChicken.class, true));
this.targetTasks.addTask(5, new EntityAIHurtByTarget(this, false));
this.tasks.addTask(1, new EntityAILookIdle(this));
this.tasks.addTask(1, new EntityAIWander(this, 0.8D));
this.tasks.addTask(1, new EntityAIAttackRanged(this, 1.25D, 20, 10.0F));

			
	    }

	    

protected void applyEntityAttributes(){
super.applyEntityAttributes();
this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.35D);
this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(12D);
if(this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE)!=null)this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(1.5D);
}

	    
protected void addRandomArmor(){

}

public void onLivingUpdate() {

super.onLivingUpdate();
		World par1World = this.worldObj;
				int par2 = (int) this.posX;
				int par3 = (int) this.posY;
				int par4 = (int) this.posZ;
		Random par5Random = this.rand;
if(true)
        for (int l = 0; l < 6; ++l)
        {
            double d0 = (double)((float)par2 + par5Random.nextFloat());
            double d1 = (double)((float)par3 + par5Random.nextFloat());
            double d2 = (double)((float)par4 + par5Random.nextFloat());
            double d3 = 0.0D;
            double d4 = 0.0D;
            double d5 = 0.0D;
            int i1 = par5Random.nextInt(2) * 2 - 1;
            d3 = ((double)par5Random.nextFloat() - 0.5D) * 0.49999999850988386D;
            d4 = ((double)par5Random.nextFloat() - 0.5D) * 0.49999999850988386D;
            d5 = ((double)par5Random.nextFloat() - 0.5D) * 0.49999999850988386D;
            par1World.spawnParticle(EnumParticleTypes.REDSTONE, d0, d1, d2, d3, d4, d5);
        }
}
		
		public void attackEntityWithRangedAttack(EntityLivingBase target, float flval){
EntityArrowCustom entityarrow = new EntityArrowCustom(this.worldObj, this);
double d0 = target.posY + (double)target.getEyeHeight() - 1.1;
double d1 = target.posX - this.posX;
double d2 = d0 - entityarrow.posY;
double d3 = target.posZ - this.posZ;
float f = MathHelper.sqrt_double(d1 * d1 + d3 * d3) * 0.2F;
entityarrow.setThrowableHeading(d1, d2 + (double)f, d3, 1.6F, 12.0F);
this.worldObj.spawnEntityInWorld(entityarrow);
}

		
		@Override
		protected Item getDropItem()
		{
			return new ItemStack(ItemHandler.Essence, 2, 3).getItem();
		}

	    @Override
	    protected net.minecraft.util.SoundEvent getAmbientSound()
	    {
	        return (net.minecraft.util.SoundEvent)net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("meepersplus:creepinoScreech"));
	    }

	    @Override
	    protected net.minecraft.util.SoundEvent getHurtSound()
	    {
	        return (net.minecraft.util.SoundEvent)net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("meepersplus:creepinoHurt"));
	    }
		
		@Override
	    protected net.minecraft.util.SoundEvent getDeathSound()
	    {
			return (net.minecraft.util.SoundEvent)net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("meepersplus:creepinoDeath"));
	    }

		@Override
	    public void onStruckByLightning(EntityLightningBolt entityLightningBolt){
			super.onStruckByLightning(entityLightningBolt);
			int i = (int)this.posX;
			int j = (int)this.posY;
			int k = (int)this.posZ;
			Entity entity = this;
			
		}

		@Override
		public void fall(float l, float d){
			super.fall(l,d);
			int i = (int)this.posX;
			int j = (int)this.posY;
			int k = (int)this.posZ;
			super.fall(l,d);
			Entity entity = this;
			
		}

		@Override
		public void onDeath(DamageSource source){
			super.onDeath(source);
			int i = (int)this.posX;
			int j = (int)this.posY;
			int k = (int)this.posZ;
			Entity entity = this;
			
			
		}

		@Override
		public boolean processInteract(EntityPlayer entity, EnumHand hand, ItemStack stack){
			super.processInteract(entity,hand,stack);
			int i = (int)this.posX;
			int j = (int)this.posY;
			int k = (int)this.posZ;
			

			return true;
		}
		
		@Override
		protected float getSoundVolume()
		{
        return 1.0F;
		}
		
	}

	


public static class ModelCreepino extends ModelBase {
public final int MCA_MIN_REQUESTED_VERSION = 5;
public HashMap<String, ModelRenderer> parts = new HashMap<String, ModelRenderer>();

ModelRenderer head;
ModelRenderer body;
ModelRenderer leg;
ModelRenderer armL;
ModelRenderer armR;

public ModelCreepino()
{

textureWidth = 128;
textureHeight = 128;

head = new ModelRenderer(this, 82, 6);
head.mirror = false;
head.addBox(0.0F, 0.0F, 0.0F, 8, 8, 9);
head.setRotationPoint(-2.0F, 15.0F, -5.0F);

head.setTextureSize(128, 128);
parts.put(head.boxName, head);

body = new ModelRenderer(this, 66, 31);
body.mirror = false;
body.addBox(0.0F, 0.0F, 0.0F, 5, 15, 5);
body.setRotationPoint(-1.0F, 0.0F, -3.0F);
body.setTextureSize(128, 128);
parts.put(body.boxName, body);

leg = new ModelRenderer(this, 102, 59);
leg.mirror = false;
leg.addBox(0.0F, 0.0F, 0.0F, 3, 20, 3);
leg.setRotationPoint(0.0F, -20.0F, -2.0F);
leg.setTextureSize(128, 128);
parts.put(leg.boxName, leg);

armL = new ModelRenderer(this, 30, 62);
armL.mirror = false;
armL.addBox(0.0F, 0.0F, 0.0F, 2, 12, 2);
armL.setRotationPoint(0.0F, 11.0F, 2.0F);
armL.setTextureSize(128, 128);
parts.put(armL.boxName, armL);

armR = new ModelRenderer(this, 46, 19);
armR.mirror = false;
armR.addBox(0.0F, 0.0F, 0.0F, 2, 12, 2);
armR.setRotationPoint(0.0F, 11.0F, -5.0F);
armR.setTextureSize(128, 128);
parts.put(armR.boxName, armR);

}

@Override
public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7)
{

//Render every non-child part
head.render(par7);
body.render(par7);
leg.render(par7);
armL.render(par7);
armR.render(par7);
}
@Override
public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {}

public ModelRenderer getModelRendererFromName(String name)
{
return parts.get(name);
}
}

}
