package al.fbi.tyga.iridium.modules.render;

import net.minecraft.src.Potion;
import net.minecraft.src.PotionEffect;

import com.gmail.mstojcevich.iridium.mods.IridiumModule;
import com.gmail.mstojcevich.iridium.mods.ModCategory;
import com.gmail.mstojcevich.mclib.MinecraftWrapper;

/**
 * A module used to see in dark areas.
 * 
 * @author Tyler
 */
public class Brightness extends IridiumModule {

	public Brightness() {
		super("Brightness", ModCategory.DISPLAY);
		this.setKeybind(48);
	}

	@Override
	public void toggleMod() {
		super.toggleMod();
		if (this.getToggled())
			MinecraftWrapper.getPlayer().addPotionEffect(
					new PotionEffect(Potion.nightVision.getId(), 1, 1));
		else
			MinecraftWrapper.getPlayer().removePotionEffect(
					Potion.nightVision.getId());
	}
}
