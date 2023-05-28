package es.uca.dss;

public class HolyGrailQuest implements Quest<HolyGrail> {
public HolyGrailQuest() { /*...*/ }
public HolyGrail embark() throws QuestFailedException {
// Do whatever it means to embark on a quest
return new HolyGrail();
}
}