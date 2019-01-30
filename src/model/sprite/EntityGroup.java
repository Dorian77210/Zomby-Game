package model.sprite;

import model.sprite.Entity;

import java.util.ArrayList;

/**
  * The class <code>GroupSprite</code> reresents a group sprite
  * @version 1.0
  * @author Dorian Terbah 
**/

public class EntityGroup extends ArrayList<Entity> {

    public EntityGroup() {
        super();
    }

    /***************************** 
    ***********COLLIDE************
    *****************************/

    /**
     * Check all of the entities that collide with another
     * @param entity The traget entity
     * @return True if the entity collides with an entity of the group, else false
     */
    public boolean collide(Entity entity) {
        for(Entity e : this) {
            if(e.collide(entity)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Check all of the entities that collide with another group
     * @param group The target group
     * @return True if the two groups are in collision with at least one entity, else false
     */
    public boolean collide(EntityGroup group) {
        for(Entity e1 : this) {
            for(Entity e2 : group) {
                if(e1.collide(e2)) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * Check and remove the entities that collide with the entity in parameter
     * @paramater entity The entity to check
     */
    public void collideAndRemove(Entity entity) {
        EntityGroup toRemove = new EntityGroup();
        for(Entity e : this) {
            if(e.collide(entity)) {
                toRemove.add(e);
            }
        }

        //remove entities
        this.removeAll(toRemove);
    }
}