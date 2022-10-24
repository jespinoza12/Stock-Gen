package controllers;

import models.Stockholder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JSONControllerTest {

    List<Stockholder> stockholders;

    @BeforeEach
    void SetupJSONController() {
        JSONController.loadJSON("src/test/java/raw_data/test.json");
        stockholders = JSONController.getStockholdersFromJSON();
    }

    @Test
    void getStockholdersFromJSONSize() {
        // arrange
        int expected = 1;

        // act
        int actual = stockholders.size();

        // assert
        assertEquals(expected, actual);
    }
}