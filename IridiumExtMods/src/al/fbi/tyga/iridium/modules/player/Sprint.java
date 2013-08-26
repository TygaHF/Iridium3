package al.fbi.tyga.iridium.modules.player;

import com.gmail.mstojcevich.iridium.Iridium;
import com.gmail.mstojcevich.iridium.events.player.EventPlayerMotionUpdate;
import com.gmail.mstojcevich.iridium.mods.IridiumModule;
import com.gmail.mstojcevich.iridium.mods.ModCategory;
import com.gmail.mstojcevich.lib.event.EventListener;
import com.gmail.mstojcevich.lib.event.HandleEvent;
import com.gmail.mstojcevich.mclib.MinecraftWrapper;

/**
 * A simple Sprint module with a decent amount of proper checks.
 * 
 * @author Tyler
 */
public class Sprint extends IridiumModule implements EventListener {

	public Sprint() {
		super("Sprint", ModCategory.PLAYER);
		Iridium.instance.eventHandler.registerListener(this);
		this.setKeybind(46);
	}

	@HandleEvent
	public void onMotionUpdate(EventPlayerMotionUpdate event) {
		if(!this.getToggled())
			return;
		
		if (isSprintingViable())
			event.getPlayer().setSprinting(true);
	}

	private boolean isSprintingViable() {
		return MinecraftWrapper.getPlayer().moveForward > 0.0f
				&& !MinecraftWrapper.getPlayer().isOnLadder()
				&& !MinecraftWrapper.getPlayer().isSneaking()
				&& !MinecraftWrapper.getPlayer().isInWater();
	}
}
