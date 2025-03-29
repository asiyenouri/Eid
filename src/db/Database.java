package db;
import db.exception.EntityNotFoundException;

import java.util.ArrayList;

public class Database {
    private static ArrayList<Entity> entities = new ArrayList<>();
    private static int Id = 1;

    public static void add(Entity e){
        e.id = Id++;
        entities.add(e.copy());

    }
    public static Entity get(int id) {
        for(Entity e: entities){
            if(e.id == id){
                return e.copy();
            }
        }
        throw new EntityNotFoundException(id);
    }
    public static void delete(int id)  {
        for(Entity e: entities){
            if(e.id == id){
                entities.remove(e);
                return;
            }
        }
        throw new EntityNotFoundException(id);
    }
    public static void update(Entity e)  {
        Entity existing = get(e.id);
        entities.set(entities.indexOf(existing), e.copy());
    }
}

