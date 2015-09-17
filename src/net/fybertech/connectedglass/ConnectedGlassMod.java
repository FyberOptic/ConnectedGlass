package net.fybertech.connectedglass;

import net.fybertech.meddle.MeddleMod;
import net.fybertech.meddleapi.MeddleClient;
import net.minecraft.block.Block;
import net.minecraft.block.BlockPane;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.init.Blocks;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.Vec3i;
import net.minecraft.world.IBlockAccess;

@MeddleMod(author="FyberOptic", depends={"dynamicmappings", "meddleapi"}, id="connectedglass", name="ConnectedGlass", version="1.0")
public class ConnectedGlassMod 
{
		
	public void init()
	{
		MeddleClient.registerCustomBlockRenderer(Blocks.glass_pane, new PaneRenderer());
	}
	
	
	
	public class PaneRenderer implements MeddleClient.ICustomBlockRenderer
	{
	
		
		public void renderFaceNorth(BlockPos pos, AxisAlignedBB aabb, TextureAtlasSprite sprite, int rotation, int brightness, WorldRenderer renderer)
		{
			float minU = sprite.getInterpolatedU((1F - aabb.maxX) * 16F);
			float maxU = sprite.getInterpolatedU((1F - aabb.minX) * 16F);
			float minV = sprite.getInterpolatedV((1F - aabb.maxY) * 16F);
			float maxV = sprite.getInterpolatedV((1F - aabb.minY) * 16F);
			double minX = pos.getX() + aabb.minX;
			double minY = pos.getY() + aabb.minY;
			double minZ = pos.getZ() + aabb.minZ;
			double maxX = pos.getX() + aabb.maxX;
			double maxY = pos.getY() + aabb.maxY;
			double maxZ = pos.getZ() + aabb.maxZ;
			
			int brightnessx = brightness & 0xFFFF;
			int brightnessy = (brightness >> 16) & 0xFFFF;
			
			renderer.addVertex(maxX, maxY, minZ).setColorRGBA_F(1,  1,  1,  1).setTextureUV(minU, minV).setBrightness(brightnessx, brightnessy).endVertex();
			renderer.addVertex(maxX, minY, minZ).setColorRGBA_F(1,  1,  1,  1).setTextureUV(minU, maxV).setBrightness(brightnessx, brightnessy).endVertex();
			renderer.addVertex(minX, minY, minZ).setColorRGBA_F(1,  1,  1,  1).setTextureUV(maxU, maxV).setBrightness(brightnessx, brightnessy).endVertex();
			renderer.addVertex(minX, maxY, minZ).setColorRGBA_F(1,  1,  1,  1).setTextureUV(maxU, minV).setBrightness(brightnessx, brightnessy).endVertex();		
			renderer.putBrightness4(brightness, brightness, brightness, brightness);
		}
		

		public void renderFaceSouth(BlockPos pos, AxisAlignedBB aabb, TextureAtlasSprite sprite, int rotation, int brightness, WorldRenderer renderer)
		{
			float minU = sprite.getInterpolatedU(aabb.minX * 16F);
			float maxU = sprite.getInterpolatedU(aabb.maxX * 16F);
			float minV = sprite.getInterpolatedV((1F - aabb.maxY) * 16F);
			float maxV = sprite.getInterpolatedV((1F - aabb.minY) * 16F);
			double minX = pos.getX() + aabb.minX;
			double minY = pos.getY() + aabb.minY;
			double minZ = pos.getZ() + aabb.minZ;
			double maxX = pos.getX() + aabb.maxX;
			double maxY = pos.getY() + aabb.maxY;
			double maxZ = pos.getZ() + aabb.maxZ;
			
			int brightnessx = brightness & 0xFFFF;
			int brightnessy = (brightness >> 16) & 0xFFFF;
			
			renderer.addVertex(minX, maxY, maxZ).setColorRGBA_F(1,  1,  1,  1).setTextureUV(minU, minV).setBrightness(brightnessx, brightnessy).endVertex();
			renderer.addVertex(minX, minY, maxZ).setColorRGBA_F(1,  1,  1,  1).setTextureUV(minU, maxV).setBrightness(brightnessx, brightnessy).endVertex();
			renderer.addVertex(maxX, minY, maxZ).setColorRGBA_F(1,  1,  1,  1).setTextureUV(maxU, maxV).setBrightness(brightnessx, brightnessy).endVertex();
			renderer.addVertex(maxX, maxY, maxZ).setColorRGBA_F(1,  1,  1,  1).setTextureUV(maxU, minV).setBrightness(brightnessx, brightnessy).endVertex();
			renderer.putBrightness4(brightness, brightness, brightness, brightness);
		}
		
		
		public void renderFaceWest(BlockPos pos, AxisAlignedBB aabb, TextureAtlasSprite sprite, int rotation, int brightness, WorldRenderer renderer)
		{
			float minU = sprite.getInterpolatedU(aabb.minZ * 16F);
			float maxU = sprite.getInterpolatedU(aabb.maxZ * 16F);
			float minV = sprite.getInterpolatedV((1F - aabb.maxY) * 16F);
			float maxV = sprite.getInterpolatedV((1F - aabb.minY) * 16F);
			double minX = pos.getX() + aabb.minX;
			double minY = pos.getY() + aabb.minY;
			double minZ = pos.getZ() + aabb.minZ;
			double maxX = pos.getX() + aabb.maxX;
			double maxY = pos.getY() + aabb.maxY;
			double maxZ = pos.getZ() + aabb.maxZ;
			
			int brightnessx = brightness & 0xFFFF;
			int brightnessy = (brightness >> 16) & 0xFFFF;			
			
			renderer.addVertex(minX, maxY, minZ).setColorRGBA_F(1,  1,  1,  1).setTextureUV(minU, minV).setBrightness(brightnessx, brightnessy).endVertex();
			renderer.addVertex(minX, minY, minZ).setColorRGBA_F(1,  1,  1,  1).setTextureUV(minU, maxV).setBrightness(brightnessx, brightnessy).endVertex();
			renderer.addVertex(minX, minY, maxZ).setColorRGBA_F(1,  1,  1,  1).setTextureUV(maxU, maxV).setBrightness(brightnessx, brightnessy).endVertex();
			renderer.addVertex(minX, maxY, maxZ).setColorRGBA_F(1,  1,  1,  1).setTextureUV(maxU, minV).setBrightness(brightnessx, brightnessy).endVertex();
			renderer.putBrightness4(brightness, brightness, brightness, brightness);
		}
		
		public void renderFaceEast(BlockPos pos, AxisAlignedBB aabb, TextureAtlasSprite sprite, int rotation, int brightness, WorldRenderer renderer)
		{
			float minU = sprite.getInterpolatedU((1F - aabb.maxZ) * 16F);
			float maxU = sprite.getInterpolatedU((1F - aabb.minZ) * 16F);
			float minV = sprite.getInterpolatedV((1F - aabb.maxY) * 16F);
			float maxV = sprite.getInterpolatedV((1F - aabb.minY) * 16F);
			double minX = pos.getX() + aabb.minX;
			double minY = pos.getY() + aabb.minY;
			double minZ = pos.getZ() + aabb.minZ;
			double maxX = pos.getX() + aabb.maxX;
			double maxY = pos.getY() + aabb.maxY;
			double maxZ = pos.getZ() + aabb.maxZ;
			
			int brightnessx = brightness & 0xFFFF;
			int brightnessy = (brightness >> 16) & 0xFFFF;
			
			renderer.addVertex(maxX, maxY, maxZ).setColorRGBA_F(1,  1,  1,  1).setTextureUV(minU, minV).setBrightness(brightnessx, brightnessy).endVertex();
			renderer.addVertex(maxX, minY, maxZ).setColorRGBA_F(1,  1,  1,  1).setTextureUV(minU, maxV).setBrightness(brightnessx, brightnessy).endVertex();
			renderer.addVertex(maxX, minY, minZ).setColorRGBA_F(1,  1,  1,  1).setTextureUV(maxU, maxV).setBrightness(brightnessx, brightnessy).endVertex();
			renderer.addVertex(maxX, maxY, minZ).setColorRGBA_F(1,  1,  1,  1).setTextureUV(maxU, minV).setBrightness(brightnessx, brightnessy).endVertex();		
			renderer.putBrightness4(brightness, brightness, brightness, brightness);
		}
		
		
		public void renderFaceTop(BlockPos pos, AxisAlignedBB aabb, TextureAtlasSprite sprite, int rotation, int brightness, WorldRenderer renderer)
		{
			float minU = sprite.getInterpolatedU(aabb.minX * 16F);
			float maxU = sprite.getInterpolatedU(aabb.maxX * 16F);
			float minV = sprite.getInterpolatedV(aabb.minZ * 16F);
			float maxV = sprite.getInterpolatedV(aabb.maxZ * 16F);
			
			double minX = pos.getX() + aabb.minX;
			double minY = pos.getY() + aabb.minY;
			double minZ = pos.getZ() + aabb.minZ;
			double maxX = pos.getX() + aabb.maxX;
			double maxY = pos.getY() + aabb.maxY;
			double maxZ = pos.getZ() + aabb.maxZ;
			
			double x1 = minX;
			double y1 = minZ;
			double x2 = minX;
			double y2 = maxZ;
			double x3 = maxX;
			double y3 = maxZ;
			double x4 = maxX;
			double y4 = minZ;
			
			if (rotation == 1) {
				
				minU = sprite.getInterpolatedU(aabb.minZ * 16F);
				maxU = sprite.getInterpolatedU(aabb.maxZ * 16F);
				minV = sprite.getInterpolatedV((1 - aabb.maxX) * 16F);
				maxV = sprite.getInterpolatedV((1 - aabb.minX) * 16F);
				
				double tempx = x1;
				double tempy = y1;
				x1 = x4;
				y1 = y4;
				x4 = x3;
				y4 = y3;
				x3 = x2;
				y3 = y2;
				x2 = tempx;
				y2 = tempy;
			}
			int brightnessx = brightness & 0xFFFF;
			int brightnessy = (brightness >> 16) & 0xFFFF;
			
			renderer.addVertex(x1, maxY, y1).setColorRGBA_F(1,  1,  1,  1).setTextureUV(minU, minV).setBrightness(brightnessx, brightnessy).endVertex();
			renderer.addVertex(x2, maxY, y2).setColorRGBA_F(1,  1,  1,  1).setTextureUV(minU, maxV).setBrightness(brightnessx, brightnessy).endVertex();
			renderer.addVertex(x3, maxY, y3).setColorRGBA_F(1,  1,  1,  1).setTextureUV(maxU, maxV).setBrightness(brightnessx, brightnessy).endVertex();
			renderer.addVertex(x4, maxY, y4).setColorRGBA_F(1,  1,  1,  1).setTextureUV(maxU, minV).setBrightness(brightnessx, brightnessy).endVertex();
			renderer.putBrightness4(brightness, brightness, brightness, brightness);
		}
		
		public void renderFaceBottom(BlockPos pos, AxisAlignedBB aabb, TextureAtlasSprite sprite, int rotation, int brightness, WorldRenderer renderer)
		{
			float minU = sprite.getInterpolatedU(aabb.minX * 16F);
			float maxU = sprite.getInterpolatedU(aabb.maxX * 16F);
			float minV = sprite.getInterpolatedV((1F - aabb.maxZ) * 16F);
			float maxV = sprite.getInterpolatedV((1F - aabb.minZ) * 16F);
			
			double minX = pos.getX() + aabb.minX;
			double minY = pos.getY() + aabb.minY;
			double minZ = pos.getZ() + aabb.minZ;
			double maxX = pos.getX() + aabb.maxX;
			double maxY = pos.getY() + aabb.maxY;
			double maxZ = pos.getZ() + aabb.maxZ;
			
			double x1 = minX;
			double y1 = maxZ;
			double x2 = minX;
			double y2 = minZ;
			double x3 = maxX;
			double y3 = minZ;
			double x4 = maxX;
			double y4 = maxZ;
			
			if (rotation == 1) {				
				minU = sprite.getInterpolatedU((1F - aabb.maxZ) * 16F);
				maxU = sprite.getInterpolatedU((1F - aabb.minZ) * 16F);
				minV = sprite.getInterpolatedV((1F - aabb.maxX) * 16F);
				maxV = sprite.getInterpolatedV((1F - aabb.minX) * 16F);
				
				double tempx = x1;
				double tempy = y1;
				x1 = x4;
				y1 = y4;
				x4 = x3;
				y4 = y3;
				x3 = x2;
				y3 = y2;
				x2 = tempx;
				y2 = tempy;
			}		
			int brightnessx = brightness & 0xFFFF;
			int brightnessy = (brightness >> 16) & 0xFFFF;
			
			renderer.addVertex(x1, minY, y1).setColorRGBA_F(1,  1,  1,  1).setTextureUV(minU, minV).setBrightness(brightnessx, brightnessy).endVertex();
			renderer.addVertex(x2, minY, y2).setColorRGBA_F(1,  1,  1,  1).setTextureUV(minU, maxV).setBrightness(brightnessx, brightnessy).endVertex();
			renderer.addVertex(x3, minY, y3).setColorRGBA_F(1,  1,  1,  1).setTextureUV(maxU, maxV).setBrightness(brightnessx, brightnessy).endVertex();
			renderer.addVertex(x4, minY, y4).setColorRGBA_F(1,  1,  1,  1).setTextureUV(maxU, minV).setBrightness(brightnessx, brightnessy).endVertex();
			renderer.putBrightness4(brightness, brightness, brightness, brightness);
		}
		
		public void renderBlock(BlockPos pos, AxisAlignedBB aabb, TextureAtlasSprite[] sprites, int[] rotations, int brightness, WorldRenderer renderer)
		{
			if (sprites[2] != null) renderFaceNorth(pos, aabb, sprites[2], rotations[2], brightness, renderer);
			if (sprites[3] != null) renderFaceSouth(pos, aabb, sprites[3], rotations[3], brightness, renderer);
			if (sprites[4] != null) renderFaceWest(pos, aabb, sprites[4], rotations[4], brightness, renderer);
			if (sprites[5] != null) renderFaceEast(pos, aabb, sprites[5], rotations[5], brightness, renderer);
			if (sprites[1] != null) renderFaceTop(pos, aabb, sprites[1], rotations[1], brightness, renderer);
			if (sprites[0] != null) renderFaceBottom(pos, aabb, sprites[0], rotations[0], brightness, renderer);
		}
		
		
		float increment = 0.0625F;
		
		AxisAlignedBB centralBB = new AxisAlignedBB(0.4375F, 0F, 0.4375F, 0.5625, 1F, 0.5625);
		AxisAlignedBB northBB = new AxisAlignedBB(0.4375F, 0F, 0F, 0.5625, 1F, 0.4375F);
		AxisAlignedBB southBB = new AxisAlignedBB(0.4375F, 0F, 0.5625F, 0.5625F, 1F, 1);
		AxisAlignedBB westBB = new AxisAlignedBB(0, 0, 0.4375F, 0.4375F, 1, 0.5625F);
		AxisAlignedBB eastBB = new AxisAlignedBB(0.5625F, 0, 0.4375F, 1, 1, 0.5625F);
		
		AxisAlignedBB centralInnerBB = new AxisAlignedBB(0.4375F, 0F + increment, 0.4375F, 0.5625, 1F - increment, 0.5625);
		AxisAlignedBB northInnerBB = new AxisAlignedBB(0.4375F, 0F + increment, 0F + increment, 0.5625, 1F - increment, 0.4375F);
		AxisAlignedBB southInnerBB = new AxisAlignedBB(0.4375F, 0F + increment, 0.5625F, 0.5625F, 1F - increment, 1 - increment);
		AxisAlignedBB westInnerBB = new AxisAlignedBB(0 + increment, 0 + increment, 0.4375F, 0.4375F, 1 - increment, 0.5625F);
		AxisAlignedBB eastInnerBB = new AxisAlignedBB(0.5625F, 0 + increment, 0.4375F, 1 - increment, 1 - increment, 0.5625F);
		
		AxisAlignedBB centralEdgeBottomBB = new AxisAlignedBB(0.4375F, 0F, 0.4375F, 0.5625, increment, 0.5625);
		AxisAlignedBB centralEdgeTopBB = new AxisAlignedBB(0.4375F, 1F - increment, 0.4375F, 0.5625, 1, 0.5625);		
		AxisAlignedBB northEdgeBottomBB = new AxisAlignedBB(0.4375F, 0F, 0F, 0.5625, increment, 0.4375F);
		AxisAlignedBB northEdgeTopBB = new AxisAlignedBB(0.4375F, 1F - increment, 0F, 0.5625, 1, 0.4375F);
		AxisAlignedBB southEdgeBottomBB = new AxisAlignedBB(0.4375F, 0F, 0.5625F, 0.5625F, increment, 1);
		AxisAlignedBB southEdgeTopBB = new AxisAlignedBB(0.4375F, 1F - increment, 0.5625F, 0.5625F, 1, 1);		
		AxisAlignedBB westEdgeBottomBB = new AxisAlignedBB(0, 0, 0.4375F, 0.4375F, increment, 0.5625F);
		AxisAlignedBB westEdgeTopBB = new AxisAlignedBB(0, 1F - increment, 0.4375F, 0.4375F, 1, 0.5625F);
		AxisAlignedBB eastEdgeBottomBB = new AxisAlignedBB(0.5625F, 0, 0.4375F, 1, increment, 0.5625F);
		AxisAlignedBB eastEdgeTopBB = new AxisAlignedBB(0.5625F, 1F - increment, 0.4375F, 1, 1, 0.5625F);
		
		AxisAlignedBB northEdgeBB = new AxisAlignedBB(0.4375F, 0F, 0F, 0.5625, 1F, increment);
		AxisAlignedBB southEdgeBB = new AxisAlignedBB(0.4375F, 0F, 1F - increment, 0.5625F, 1F, 1);
		AxisAlignedBB westEdgeBB = new AxisAlignedBB(0, 0, 0.4375F, increment, 1, 0.5625F);
		AxisAlignedBB eastEdgeBB = new AxisAlignedBB(1F - increment, 0, 0.4375F, 1, 1, 0.5625F);
		
		
		
		@Override
		public boolean renderBlock(IBlockState state, BlockPos pos, IBlockAccess blockAccess, WorldRenderer renderer) 
		{			
			TextureAtlasSprite sprite = Minecraft.getMinecraft().getTextureMapBlocks().getAtlasSprite("minecraft:blocks/glass");
			TextureAtlasSprite sprite_top = Minecraft.getMinecraft().getTextureMapBlocks().getAtlasSprite("minecraft:blocks/glass_pane_top");			
			
			Block block = state.getBlock();
			state = block.getActualState(state,  blockAccess,  pos);
			
			// We'll need to rotate the top and bottom textures 90 degrees on glass rendered east/west.
			int[] rotationsX = new int[] { 1, 1, 0, 0, 0, 0 };
			int[] rotationsZ = new int[] { 0, 0, 0, 0, 0, 0 };		
			
			
			// Only used for debugging face renderers
			/*if (1==1) { 
				state.getBlock().setBlockBoundsBasedOnState(blockAccess,  pos);
				renderBlock(pos, state.getBlock().getBlockBounds(state), new TextureAtlasSprite[] { sprite, sprite, sprite, sprite, sprite, sprite }, rotationsX, renderer);
				return true;
			}*/
			
			
			int brightness = block.getMixedBrightnessForBlock(state, blockAccess, pos);			
			
			// Discover which directions we need to render pane segments into
			boolean north = state.getValue(BlockPane.NORTH);
			boolean south = state.getValue(BlockPane.SOUTH);
			boolean west = state.getValue(BlockPane.WEST);
			boolean east = state.getValue(BlockPane.EAST);			
			
			// Discover which neighbors are glass panes
			boolean glassDown = blockAccess.getBlockState(pos.down()).getBlock() == block;
			boolean glassUp = blockAccess.getBlockState(pos.up()).getBlock() == block;			
			boolean glassNorth = blockAccess.getBlockState(pos.north()).getBlock() == block;
			boolean glassSouth = blockAccess.getBlockState(pos.south()).getBlock() == block;
			boolean glassWest = blockAccess.getBlockState(pos.west()).getBlock() == block;
			boolean glassEast = blockAccess.getBlockState(pos.east()).getBlock() == block;
			
			// Sides with null textures aren't rendered
			TextureAtlasSprite[] centralSpritesTop = 	{ null, sprite_top, (north ? null : sprite), (south ? null : sprite), (west ? null : sprite), (east ? null : sprite) };
			TextureAtlasSprite[] centralSpritesBottom = { sprite_top, null, (north ? null : sprite), (south ? null : sprite), (west ? null : sprite), (east ? null : sprite) };
			TextureAtlasSprite[] northSpritesTop =    { null, sprite_top, null, null, sprite, sprite };
			TextureAtlasSprite[] northSpritesBottom = { sprite_top, null, null, null, sprite, sprite };
			TextureAtlasSprite[] southSpritesTop =    { null, sprite_top, null, null, sprite, sprite };
			TextureAtlasSprite[] southSpritesBottom = { sprite_top, null, null, null, sprite, sprite };
			TextureAtlasSprite[] westSpritesTop =     { null, sprite_top, sprite, sprite, null, null };
			TextureAtlasSprite[] westSpritesBottom =  { sprite_top, null, sprite, sprite, null, null };
			TextureAtlasSprite[] eastSpritesTop =     { null, sprite_top, sprite, sprite, null, null };
			TextureAtlasSprite[] eastSpritesBottom =  { sprite_top, null, sprite, sprite, null, null };
			
			TextureAtlasSprite[] northSpritesEdge =   { null, null, null, null, sprite, sprite };
			TextureAtlasSprite[] southSpritesEdge =   { null, null, null, null, sprite, sprite };
			TextureAtlasSprite[] westSpritesEdge =    { null, null, sprite, sprite, null, null };
			TextureAtlasSprite[] eastSpritesEdge =    { null, null, sprite, sprite, null, null };
			
			TextureAtlasSprite[] centralInnerSprites = { null, null, (north ? null : sprite), (south ? null : sprite), (west ? null : sprite), (east ? null : sprite) };
			TextureAtlasSprite[] northInnerSprites =   { null, null, null, null, sprite, sprite };
			TextureAtlasSprite[] southInnerSprites =   { null, null, null, null, sprite, sprite };
			TextureAtlasSprite[] westInnerSprites =    { null, null, sprite, sprite, null, null };
			TextureAtlasSprite[] eastInnerSprites =    { null, null, sprite, sprite, null, null };
			
			
			// Render vertical center (no edges)
			renderBlock(pos, centralInnerBB, centralInnerSprites, rotationsZ, brightness, renderer);			
			
			// Render panes in each necessary direction (no edges)
			if (north) renderBlock(pos, northInnerBB, northInnerSprites, rotationsZ, brightness, renderer);
			if (south) renderBlock(pos, southInnerBB, southInnerSprites, rotationsZ, brightness, renderer);			
			if (west) renderBlock(pos, westInnerBB, westInnerSprites, rotationsX, brightness, renderer);
			if (east) renderBlock(pos, eastInnerBB, eastInnerSprites, rotationsX, brightness, renderer);
			
			// Render upper and lower horizontal edges where necessary
			if (!glassUp) {
				renderBlock(pos, centralEdgeTopBB, centralSpritesTop, rotationsZ, brightness, renderer);
				if (north) renderBlock(pos, northEdgeTopBB, northSpritesTop, rotationsZ, brightness, renderer); 
				if (south) renderBlock(pos, southEdgeTopBB, southSpritesTop, rotationsZ, brightness, renderer);
				if (west) renderBlock(pos, westEdgeTopBB, westSpritesTop, rotationsX, brightness, renderer);
				if (east) renderBlock(pos, eastEdgeTopBB, eastSpritesTop, rotationsX, brightness, renderer);
			}
			if (!glassDown) {
				renderBlock(pos, centralEdgeBottomBB, centralSpritesBottom, rotationsZ, brightness, renderer);
				if (north) renderBlock(pos, northEdgeBottomBB, northSpritesBottom, rotationsZ, brightness, renderer);
				if (south) renderBlock(pos, southEdgeBottomBB, southSpritesBottom, rotationsZ, brightness, renderer);
				if (west) renderBlock(pos, westEdgeBottomBB, westSpritesBottom, rotationsX, brightness, renderer);
				if (east) renderBlock(pos, eastEdgeBottomBB, eastSpritesBottom, rotationsX, brightness, renderer);
			}
			
			// Render vertical edges where necessary
			if (!glassNorth && north) renderBlock(pos, northEdgeBB, northSpritesEdge, rotationsZ, brightness, renderer);
			if (!glassSouth && south) renderBlock(pos, southEdgeBB, southSpritesEdge, rotationsZ, brightness, renderer);
			if (!glassWest && west) renderBlock(pos, westEdgeBB, westSpritesEdge, rotationsX, brightness, renderer);
			if (!glassEast && east) renderBlock(pos, eastEdgeBB, eastSpritesEdge, rotationsX, brightness, renderer);
			
			return true;
		}
		
	}
	
}
