package net.teamuni.playerinteraction;

import org.bukkit.Bukkit;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public final class Playerinteraction extends JavaPlugin implements Listener {

    String shiftRightClickCommand = "";

    @Override
    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(this, this);
        this.saveDefaultConfig();
        getConfigMessages();
    }

    @Override
    public void onDisable() {
    }

    public void getConfigMessages() {
        try {
            shiftRightClickCommand = getConfig().getString("shift_right_click_command");
        } catch (NullPointerException e) {
            e.printStackTrace();
            getLogger().info("config.yml에서 정보를 불러오는데 문제가 발생하였습니다.");
        }
    }

    @EventHandler
    public void onPlayerInteractAtEntity(PlayerInteractEntityEvent event) {
        Player p = event.getPlayer();
        List<String> rightClickWorld = getConfig().getStringList("enable_world");
        if (event.getRightClicked().getType().equals(EntityType.PLAYER) && p.isSneaking()) {
            if (rightClickWorld.stream().anyMatch(current_world -> p.getWorld().equals(Bukkit.getWorld(current_world)))) {
                String clickPlayerName = (event.getRightClicked()).getName();
                String replacedShiftRightClick = (shiftRightClickCommand.replace("%player%", clickPlayerName));
                p.performCommand(replacedShiftRightClick);
            }
        }
    }
}
