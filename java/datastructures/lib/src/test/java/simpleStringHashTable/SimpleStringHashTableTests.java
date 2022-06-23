package simpleStringHashTable;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SimpleStringHashTableTests {
  @Test
  public void testCanInstantiateSimpleStringHashTableTests() {
    SimpleStringHashTable sut = new SimpleStringHashTable();
    assertTrue(sut != null);
  }

  // RepeatWord method tests
  @Test
  public void testRepeatWordReturnsEmptyStringWithEmptyInput() {

  }

  @Test
  public void testRepeatWordReturnsEmptyStringWithSingleLetterInput() {

  }

  @Test
  public void testRepeatWordReturnsEmptyStringWithSingleWordInput() {

  }

  @Test
  public void testRepeatWordReturnsFirstDuplicateWord() {

  }

  @Test
  public void testRepeatWordReturnsFirstDuplicateWordLargeInput() {

  }

  // Hash method tests
  @Test
  public void testHashReturnsValidInteger() {

  }

  @Test
  public void testHashDoesNotThrowOnEmptyStringInput() {

  }

  @Test
  public void testHashDoesNotThrowOnLargeString() {

  }

  // SumChar method tests
  @Test
  public void testSumCharsDoesNotThrowOnEmptyStringInput() {

  }

  @Test
  public void testSumCharsReturnsValidLong() {
    SimpleStringHashTable sut = new SimpleStringHashTable();
    String stringInput = "abcdef";
    long expectedResult = 597L;

    long actualResult = sut.sumChars(stringInput);
    assertEquals(expectedResult, actualResult);
  }

  @Test
  public void testSumCharsDoesNotThrowOnLargeString() {
    String longInput = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse aliquam euismod sapien " +
      "ut facilisis. Nulla sodales nulla eget enim facilisis, in molestie augue malesuada. In vitae nulla porttitor, " +
      "eleifend nunc non, facilisis magna. Phasellus ac augue eu turpis tempor volutpat non in sapien. In iaculis " +
      "tellus sapien, nec maximus lorem tristique non. Maecenas vulputate feugiat lobortis. Curabitur non libero eu " +
      "nisl eleifend placerat sed eu augue. Aliquam et nulla urna. Duis vel facilisis lorem. Proin laoreet ut nulla " +
      "in elementum. Donec facilisis neque a semper porta. Nam rhoncus non sapien eu aliquam. Nunc varius dui neque, " +
      "eget consequat erat ornare eu. Phasellus sollicitudin libero et dui pulvinar dignissim. Fusce lorem nisl, " +
      "mollis id mi sed, lacinia malesuada turpis. Sed nec dolor velit. Mauris lacus sapien, tristique ut ipsum in, " +
      "scelerisque venenatis quam. Curabitur varius velit auctor felis volutpat, in finibus dolor sollicitudin. " +
      "Fusce a congue velit, ac fermentum ex. Duis semper est et sapien suscipit tincidunt. Maecenas malesuada, odio " +
      "ac interdum interdum, mi ipsum pharetra nisl, id molestie erat sem id ex. In hac habitasse platea dictumst. " +
      "Etiam semper augue eu lacus euismod elementum. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed " +
      "ligula mauris, congue sagittis odio vel, egestas imperdiet metus. In hac habitasse platea dictumst. Quisque " +
      "in ligula justo. Curabitur fermentum scelerisque enim nec vulputate. Donec eget ex nisi. Nulla commodo ante " +
      "eu eros consectetur convallis a eleifend lacus. Cras dapibus tortor nulla, quis mollis lorem cursus quis. " +
      "Aliquam rhoncus nec mauris eget volutpat. Phasellus blandit rutrum tortor nec blandit. Phasellus urna neque, " +
      "commodo sed ornare quis, facilisis non urna. Proin porttitor vehicula suscipit. Curabitur consectetur nunc " +
      "nec nibh imperdiet, et vulputate orci aliquet. Maecenas tempus neque mollis tortor laoreet ullamcorper. " +
      "Maecenas et erat porttitor orci maximus congue a nec elit. Morbi placerat elit ut enim rhoncus egestas. " +
      "Nullam pellentesque et tellus non consectetur. Etiam eu condimentum lacus. Phasellus interdum felis " +
      "efficitur massa lacinia posuere vel quis ligula. Integer massa sapien, commodo at velit malesuada, semper " +
      "semper leo. Nam a luctus enim, sed ornare enim. In sed nisl quis elit vulputate tempor. Etiam non porta mi. " +
      "Cras pellentesque porta tellus nec consequat. Quisque felis metus, convallis ullamcorper auctor id, lacinia " +
      "sed diam. Mauris convallis, sem nec accumsan fringilla, augue sapien elementum ante, sed porta nibh sapien " +
      "at mi. Etiam mollis, odio sed tincidunt iaculis, arcu libero hendrerit lorem, non maximus eros erat id " +
      "justo. Duis placerat enim eu quam mollis lobortis. Vivamus tincidunt elementum tellus sodales finibus. Sed " +
      "quis sapien urna. Quisque rhoncus dui in finibus bibendum. Phasellus a finibus urna. Quisque eget mauris " +
      "faucibus, euismod odio vitae, aliquet turpis. Curabitur pharetra varius quam at convallis. Nam nec mauris enim.";

    SimpleStringHashTable sut = new SimpleStringHashTable();

    assertDoesNotThrow(() -> {
      sut.sumChars(longInput);
    });
  }

}
