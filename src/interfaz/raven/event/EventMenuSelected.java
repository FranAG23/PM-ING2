package interfaz.raven.event;

// Este evento ocurre cuando el usuario hace click en alguno de los botones del 
// panel izquierdo. 
public interface EventMenuSelected {
    public void menuSelected(int menuIndex, int subMenuIndex);
}
