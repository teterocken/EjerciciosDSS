package es.uca.dss;

public interface Quest<T> {
    abstract T embark()
    throws QuestFailedException;
    }

