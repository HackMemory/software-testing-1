package task3;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Debate extends AbstractPastime implements Actionable {
    public String theme;

    @Override
    public String startJustDoIt() {
        this.status = PastimeStatus.inProcess;
        return "Начали дебаты: " + theme;
    }

    @Override
    public String stopJustDoIt() {
        this.status = PastimeStatus.finished;
        return "Закончили дебаты: " + theme;
    }

    @Override
    public String toString(){
        return "Тема дебатов: " + theme + ", статус: " + this.status.name();
    }
}
