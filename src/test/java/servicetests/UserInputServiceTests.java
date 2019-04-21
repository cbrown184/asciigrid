package servicetests;

import org.junit.Test;
import org.mockito.Mockito;
import services.UserInputListener;
import services.UserInputService;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class UserInputServiceTests {

  UserInputListener userInputListener = Mockito.mock(UserInputListener.class);
  UserInputService userInputService = new UserInputService(userInputListener);

  @Test
  public void quitCommandTest() {
    userInputService.command("Q");
    verify(userInputListener, times(1)).quit();
    verifyNoMoreInteractions(userInputListener);
  }

  @Test
  public void drawLineCommandTest() {
    userInputService.command("L 12 13 41 1213");
    verify(userInputListener, times(1)).drawLineCommand(any(), any());
    verifyNoMoreInteractions(userInputListener);
  }

  @Test
  public void drawRectangleCommandTest() {
    userInputService.command("R 12 13 41 1213");
    verify(userInputListener, times(1)).drawRectangleCommand(any(), any());
    verifyNoMoreInteractions(userInputListener);
  }

  @Test
  public void createCanvasCommandtest() {
    userInputService.command("C 12 13");
    verify(userInputListener, times(1)).createCanvasCommand(anyInt(), anyInt());
    verifyNoMoreInteractions(userInputListener);
  }

}
