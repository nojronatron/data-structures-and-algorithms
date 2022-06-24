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
    String expectedResult = "";

    SimpleStringHashTable sut = new SimpleStringHashTable();
    String actualResult = sut.repeatedWord("");

    assertEquals(expectedResult, actualResult, "Empty string input should return empty string output.");
  }

  @Test
  public void testRepeatWordReturnsEmptyStringWithSingleLetterInput() {
    String expectedResult = "";
    String singleLetterInput = "j";

    SimpleStringHashTable sut = new SimpleStringHashTable();
    String actualResult = sut.repeatedWord(singleLetterInput);

    assertEquals(expectedResult, actualResult, "Single letter input should return empty string output.");
  }

  @Test
  public void testRepeatWordReturnsEmptyStringWithSingleWordInput() {
    String expectedResult = "";
    String singleWordInput = "jon";

    SimpleStringHashTable sut = new SimpleStringHashTable();
    String actualResult = sut.repeatedWord(singleWordInput);

    assertEquals(expectedResult, actualResult, "Single word input returns empty string output.");
  }

  @Test
  public void testRepeatWordReturnsFirstDuplicateWord() {
    String expectedResult = "firstDuplicate";
    String inputStream = "the firstDuplicate duplicate word should be returned as firstDuplicate";

    SimpleStringHashTable sut = new SimpleStringHashTable();
    String actualResult = sut.repeatedWord(inputStream);

    assertEquals(expectedResult, actualResult, "First repeated word in a stream of Strings is returned.");
  }

  @Test
  public void testRepeatWordReturnsFirstDuplicateWordLargeInput() {
    String expectedResult = "it";
    String inputStream = "It was the best of times, it was the worst of times, it was the age of wisdom, it was the age of foolishness, it was the epoch of belief, it was the epoch of incredulity, it was the season of Light, it was the season of Darkness, it was the spring of hope, it was the winter of despair, we had everything before us, we had nothing before us, we were all going direct to Heaven, we were all going direct the other way – in short, the period was so far like the present period, that some of its noisiest authorities insisted on its being received, for good or for evil, in the superlative degree of comparison only...";

    SimpleStringHashTable sut = new SimpleStringHashTable();
    String actualResult = sut.repeatedWord(inputStream);

    assertEquals(expectedResult, actualResult, "Large input stream should still find and return the first " +
      "duplicate. For this input the method should return \"it\".");
  }

  // Hash method tests
  @Test
  public void testHashReturnsValidInteger() {
    String stringInput = "abcdef";
    int expectedResult = 4;

    SimpleStringHashTable sut = new SimpleStringHashTable(11);

    int actualResult = sut.hash(stringInput);
    assertEquals(expectedResult, actualResult);
  }

  @Test
  public void testHashDoesNotThrowOnEmptyStringInput() {
    String stringInput = " ";
    int expectedResult = 6;

    SimpleStringHashTable sut = new SimpleStringHashTable(11);

    assertDoesNotThrow(() -> {
      sut.hash(stringInput);
    });

    int actualResult = sut.hash(stringInput);
    assertEquals(expectedResult, actualResult);
  }

  @Test
  public void testHashDoesNotThrowOnLargeString() {
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

    int expectedResult = 7;

    SimpleStringHashTable sut = new SimpleStringHashTable(11);

    assertDoesNotThrow(() -> {
      sut.hash(longInput);
    });

    int actualResult = sut.hash(longInput);
    assertEquals(expectedResult, actualResult);
  }

  // SumChar method tests
  @Test
  public void testSumCharsDoesNotThrowOnEmptyStringInput() {
    SimpleStringHashTable sut = new SimpleStringHashTable();
    String stringInput = " ";
    long expectedResult = 32L;

    assertDoesNotThrow(() -> {
      sut.sumChars(stringInput);
    });

    long actualResult = sut.sumChars(stringInput);

    assertEquals(expectedResult, actualResult);
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
