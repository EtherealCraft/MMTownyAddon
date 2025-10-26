package com.ehhthan.mythicmobstownyaddon;

import com.ehhthan.mythicmobstownyaddon.condition.CanDestroyCondition;
import com.ehhthan.mythicmobstownyaddon.condition.InMyTownCondition;
import com.ehhthan.mythicmobstownyaddon.condition.InWildernessCondition;
import com.ehhthan.mythicmobstownyaddon.condition.TownPvpEnabledCondition;
import com.palmergames.bukkit.towny.TownyAPI;
import io.lumine.mythic.bukkit.events.MythicConditionLoadEvent;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class MythicMobsTownyAddon extends JavaPlugin implements Listener {
    private TownyAPI townyAPI;

    @Override
    public void onEnable() {
        this.townyAPI = TownyAPI.getInstance();
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onMythicConditionLoad(MythicConditionLoadEvent event) {
        if (event.getConditionName().equalsIgnoreCase("inWild")
        || event.getConditionName().equalsIgnoreCase("inWilderness"))
            event.register(new InWildernessCondition(townyAPI));

        if (event.getConditionName().equalsIgnoreCase("inMyTown"))
            event.register(new InMyTownCondition(townyAPI));

        if (event.getConditionName().equalsIgnoreCase("isPvp"))
            event.register(new TownPvpEnabledCondition(townyAPI));

        if (event.getConditionName().equalsIgnoreCase("canDestroy"))
            event.register(new CanDestroyCondition());
    }
}
