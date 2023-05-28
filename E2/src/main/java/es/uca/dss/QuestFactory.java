package es.uca.dss;

import org.springframework.beans.factory.FactoryBean;

public class QuestFactory implements FactoryBean<Quest<?>> {
    @Override
    public Quest<?> getObject() throws Exception {
        return new HolyGrailQuest();
    }

    @Override
    public Class<?> getObjectType() {
        return Quest.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}

