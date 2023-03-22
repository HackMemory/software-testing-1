package task3;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Game extends AbstractPastime implements Actionable {
    public String name;

    @Override
    public String startJustDoIt() {
        this.status = PastimeStatus.inProcess;
        return "Начали игру: " + name;
    }

    @Override
    public String stopJustDoIt() {
        this.status = PastimeStatus.finished;
        return "Закончили игру: " + name;
    }

    @Override
    public String toString(){
        return "Игра: " + name + ", статус: " + this.status.name();
    }
}
