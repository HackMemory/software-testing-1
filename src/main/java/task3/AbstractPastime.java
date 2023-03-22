package task3;

import lombok.Data;

import java.util.List;

@Data
public class AbstractPastime {
    public PastimeStatus status;
    public List<Creature> creatureList;

    public AbstractPastime(){
        status = PastimeStatus.notStarted;
    }

    public String addCreature(Creature c) {
        if(creatureList.isEmpty()) {
            creatureList.add(c);
        }else{
            int lastIndex = creatureList.size()-1;
            Creature lastCreature = creatureList.get(lastIndex);
            if(!lastCreature.getUniverse().equals(c.getUniverse())){
                return "Разные вселенные";
            }
        }

        return "Добавлен";
    }
}
