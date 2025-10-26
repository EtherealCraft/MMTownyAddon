package com.ehhthan.mythicmobstownyaddon.condition;

import com.palmergames.bukkit.towny.TownyAPI;
import io.lumine.mythic.api.adapters.AbstractLocation;
import io.lumine.mythic.api.skills.conditions.ILocationCondition;
import io.lumine.mythic.bukkit.BukkitAdapter;

public class TownPvpEnabledCondition implements ILocationCondition {
    private final TownyAPI townyAPI;

    public TownPvpEnabledCondition(TownyAPI api) {
        this.townyAPI = api;
    }

    @Override
    public boolean check(AbstractLocation location) {
        return townyAPI.isPVP(BukkitAdapter.adapt(location));
    }
}
