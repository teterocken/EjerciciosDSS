package es.uca.dss;

public class KnightOfTheRoundTable implements Knight {
    private String name;
    private Quest<?> quest;

    public KnightOfTheRoundTable(){}

    public KnightOfTheRoundTable(String name) {
    this.name = name;
    }

    public Object embarkOnQuest() throws QuestFailedException {
    return quest.embark();
    }

    public void setQuest(Quest<?> quest) {
    this.quest = quest;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    }
    