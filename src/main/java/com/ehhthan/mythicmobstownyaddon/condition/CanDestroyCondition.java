package com.ehhthan.mythicmobstownyaddon.condition;

import com.palmergames.bukkit.towny.object.TownyPermission;
import com.palmergames.bukkit.towny.utils.PlayerCacheUtil;
import io.lumine.mythic.api.adapters.AbstractEntity;
import io.lumine.mythic.api.skills.conditions.IEntityCondition;
import io.lumine.mythic.bukkit.BukkitAdapter;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class CanDestroyCondition implements IEntityCondition {
    public CanDestroyCondition() {}

    @Override
    public boolean check(AbstractEntity abstractEntity) {
        if (!abstractEntity.isPlayer()) return false;
        Player player = BukkitAdapter.adapt(abstractEntity.asPlayer());
        Block block = player.getTargetBlock(null, 5);
        return PlayerCacheUtil.getCachePermission(
                BukkitAdapter.adapt(abstractEntity.asPlayer()),
                block.getLocation(),
                block.getType(),
                TownyPermission.ActionType.DESTROY);
    }
}
