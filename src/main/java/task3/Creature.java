package task3;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Creature {

    public String name;
    public String race;
    public Universe universe;

    @Override
    public String toString(){
        return this.name + ", раса: " + this.race + ", вселенная: " + this.universe.getName();
    }
}
