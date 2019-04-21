package wiring;

import com.google.inject.AbstractModule;
import com.google.inject.Key;
import com.google.inject.TypeLiteral;
import components.LineCalculator;
import components.ListGrid;
import components.impl.BresenhamLineCalculator;
import components.impl.ListGridImpl;
import controller.AsciiGridController;
import services.GridService;
import services.UserInputListener;

public class AsciiGridModule extends AbstractModule {
  @Override
  protected void configure() {
    ListGridImpl<Boolean> myClassInstanceOfMyType = new ListGridImpl<Boolean>();
    bind(Key.get(new TypeLiteral<ListGrid<Boolean>>() {
    })).toInstance(myClassInstanceOfMyType);
    bind(ListGrid.class).to(ListGridImpl.class).asEagerSingleton();
    bind(LineCalculator.class).to(BresenhamLineCalculator.class);
    bind(GridService.class).asEagerSingleton();
    bind(UserInputListener.class).to(AsciiGridController.class).asEagerSingleton();
  }
}
