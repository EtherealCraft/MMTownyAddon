package com.ehhthan.mythicmobstownyaddon.condition;

import com.palmergames.bukkit.towny.TownyAPI;
import com.palmergames.bukkit.towny.object.Town;
import io.lumine.mythic.api.adapters.AbstractEntity;
import io.lumine.mythic.api.skills.conditions.IEntityCondition;
import io.lumine.mythic.bukkit.BukkitAdapter;

public class InMyTownCondition implements IEntityCondition {
    private final TownyAPI townyAPI;

    public InMyTownCondition(TownyAPI api) {
        this.townyAPI = api;
    }
    @Override
    public boolean check(AbstractEntity abstractEntity) {
        Town townOrNull = townyAPI.getTownOrNull(townyAPI.getTownBlock(BukkitAdapter.adapt(abstractEntity.getLocation())));
        if (townOrNull == null || !abstractEntity.isPlayer()) {
            return false;
        }
        return townOrNull.hasResident(BukkitAdapter.adapt(abstractEntity.asPlayer()).getUniqueId());
    }
}
