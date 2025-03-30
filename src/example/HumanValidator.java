package example;

import db.Entity;
import db.Validator;
import db.exception.InvalidEntityException;
import example.Human;
public class HumanValidator implements Validator {
    @Override
    public void validate(Entity entity) throws InvalidEntityException {

        if (!(entity instanceof Human)) {
            throw new InvalidEntityException("Human entity is not a Human");
        }
        Human human = (Human) entity;
        if(human.age < 0) {
            throw new InvalidEntityException("Age must be a positive integer");
        }
        if(human.name == null || human.name.isEmpty()) {
            throw new InvalidEntityException("Human name cannot be empty");
        }
    }
}
