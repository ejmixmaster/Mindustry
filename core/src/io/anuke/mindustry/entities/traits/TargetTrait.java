package io.anuke.mindustry.entities.traits;

import io.anuke.mindustry.game.Team;
import io.anuke.ucore.entities.trait.PosTrait;
import io.anuke.ucore.entities.trait.SolidTrait;
import io.anuke.ucore.entities.trait.VelocityTrait;

/**
 * Base interface for targetable entities.
 */
public interface TargetTrait extends PosTrait, VelocityTrait{

    boolean isDead();

    Team getTeam();

    default float getTargetVelocityX(){
        if(this instanceof SolidTrait){
            return getX() - ((SolidTrait) this).lastPosition().x;
        }else{
            return getVelocity().x;
        }
    }

    default float getTargetVelocityY(){
        if(this instanceof SolidTrait){
            return getY() - ((SolidTrait) this).lastPosition().y;
        }else{
            return getVelocity().y;
        }
    }

    /**
     * Whether this entity is a valid target.
     */
    default boolean isValid(){
        return !isDead();
    }
}
