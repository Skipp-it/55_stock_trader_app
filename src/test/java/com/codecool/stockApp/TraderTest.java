package com.codecool.stockApp;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

// TODO
class TraderTest {

    StockAPIService stockService = mock(StockAPIService.class);
    Logger logger = mock(Logger.class);
    Trader trader = new Trader(stockService, logger);

    @Test
        // Bid was lower than price, buy should return false.
    void testBidLowerThanPrice() throws IOException {
        when(stockService.getPrice("AAPL")).thenReturn(200.00);
        assertFalse(trader.buy("AAPL", 100.00));
    }

    @Test
        // bid was equal or higher than price, buy() should return true.
    void testBidHigherThanPrice() throws IOException {
        when(stockService.getPrice("AAPL")).thenReturn(200.00);
        assertTrue(trader.buy("AAPL", 300.00));

    }
}