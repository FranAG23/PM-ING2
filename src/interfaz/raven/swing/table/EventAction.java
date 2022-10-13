package interfaz.raven.swing.table;

import interfaz.raven.model.ModelStudent;

public interface EventAction {

    public void delete(ModelStudent student);

    public void update(ModelStudent student);
}
