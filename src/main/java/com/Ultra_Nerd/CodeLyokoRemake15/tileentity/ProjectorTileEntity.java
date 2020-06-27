package com.Ultra_Nerd.CodeLyokoRemake15.tileentity;

public class ProjectorTileEntity //extends TileEntity implements ITickable
{

/*
    public static boolean valid;
    private boolean OOOF;
    private int POWER;
    private ITickable powers;
    //private IInventory tories;
    private int x, y, z;

    public ProjectorTileEntity(TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
    }


    @Override
    public void tick() {

        boolean once = false;
        boolean onceback = false;


        checkstruct();
        once = false;
        if (valid) {
            HologramProjectorBlock.SetModel(true, this.world, this.pos);
            Block blockState = world.getBlockState(new BlockPos(this.pos.getX(), this.pos.getY() + 1, this.pos.getZ())).getBlock();


            QuantSteelBlock.SetModel2(true, world, pos);
            QuantSteelBlock.trans2 = true;
            HologramProjectorBlock.trans = true;


            if (blockState == Blocks.GLASS && !once) {

                world.setBlockState(this.pos.add(0, 1, 0), ModBlocks.TRANSPARENT.get().getDefaultState());

                once = true;
            }
            //useUran();

        } else {
            QuantSteelBlock.SetModel2(false, world, pos);
            QuantSteelBlock.trans2 = false;
            HologramProjectorBlock.trans = false;
            HologramProjectorBlock.SetModel(false, this.world, this.pos);
            if (world.getBlockState(this.pos.add(0, 1, 0)).getBlock().getDefaultState() != Blocks.GLASS.getDefaultState() && onceback) {
                world.setBlockState(this.pos.add(0, 1, 0), Blocks.GLASS.getDefaultState());
                onceback = false;
            }

        }


    }


    private void checkstruct() {

        x++;
        if (x > 1) {
            System.out.println("notworking");
            x = -1;
            y++;
            if (y > 0) {
                y = -1;
                z++;
                if (z > 1) {
                    z = -1;
                    valid = !OOOF && (POWER == 1 || POWER == 2 || POWER == 3 || POWER == 4);
                    OOOF = false;
                    POWER = 0;
                    System.out.println("Valid" + valid);

                }
            }
        }

        if (x == 0 && y == 0 && z == 0) {
            return;
        }

        Block block = world.getBlockState(new BlockPos(this.pos.getX() + x, this.pos.getY() + y, this.pos.getZ() + z)).getBlock();
        Block Focus = world.getBlockState(new BlockPos(this.pos.getX(), this.pos.getY() + 1, this.pos.getZ())).getBlock();

        if (Focus != Blocks.GLASS) {
            if (Focus != ModBlocks.TRANSPARENT.get()) {
                OOOF = true;
            }
        }


        if (y == 0 && x != 0 ^ z != 0) {
            TileEntity te = world.getTileEntity(new BlockPos(this.pos.getX() + x, this.pos.getY() + y, this.pos.getZ() + z));
            //TileEntity te2 = world.getTileEntity(new BlockPos(this.pos.getX() + x, this.pos.getY() + y, this.pos.getZ() + z));
            if (te instanceof ITickable) {
                POWER++;
                powers = (ITickable) te;
            } else if (block != ModBlocks.QUANTUM_STEEL.get()) {
                OOOF = true;
            }
		   /* if(te2 instanceof IInventory)
			{
				POWER++;
				tories = (IInventory)te2;
			}
			
			else if(block != Blocks.IRON_BLOCK)
			{
				OOOF = true;
			}
        } else if (block != ModBlocks.QUANTUM_STEEL.get()) {
            OOOF = true;
        }
    }
	
	
	/*private void useUran()
	{
		if(tories != null)
		{
			System.out.println("notnull");
			for(int i = 0; i < tories.getSizeInventory(); i++)
			{
				
				ItemStack stack = tories.getStackInSlot(i);
				if(stack != null) {
					
					if(stack.getItem() == ModItems.URANIUM_ISOTOPE235U)
					{
					tories.decrStackSize(i, 1);
					System.out.println("used uranium");
					}
				}
			}
		}
	}*/

}
