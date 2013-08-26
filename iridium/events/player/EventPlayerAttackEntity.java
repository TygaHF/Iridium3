/*
 * EventPlayerAttackEntity
 *
 * 8/25/13
 *
 * Copyright (c) 2013, Marcus Stojcevich
 * All rights reserved.
 * See the included LICENSE file
 */

package com.gmail.mstojcevich.iridium.events.player;

import net.minecraft.src.EntityLivingBase;
import net.minecraft.src.EntityPlayer;

/**
 * Event fired whenever the player attacks an entity
 * @author marcusant
 * @version 1
 * @since 8/25/13 12:46 AM
 */
public class EventPlayerAttackEntity extends EventPlayer {

    private EntityLivingBase attackedEntity;

    public EventPlayerAttackEntity(EntityPlayer player, EntityLivingBase attackedEntity) {
        super(player);
        this.attackedEntity = attackedEntity;
    }

    /**
     * @return the entity that the player attacked
     */
    public EntityLivingBase getAttackedEntity() {
        return this.attackedEntity;
    }

}
