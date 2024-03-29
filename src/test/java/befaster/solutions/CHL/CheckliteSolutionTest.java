package befaster.solutions.CHL;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CheckliteSolutionTest {
    private CheckliteSolution checkliteSolution;

    @Before
    public void setUp() throws Exception {
        checkliteSolution = new CheckliteSolution();
    }

    @Test
    public void givenOneAProductInBasket_thenPriceIs50() {
        assertThat(checkliteSolution.checklite("A"), Matchers.is(50));
    }

    @Test
    public void givenOneAandOneBInBasket_thenTotalIs80() {
        assertThat(checkliteSolution.checklite("AB"), Matchers.is(80));
    }

    @Test
    public void givenThreeAProductsInBasket_thenTotalIsSpecialOfferOf130() {
        assertThat(checkliteSolution.checklite("AAA"), Matchers.is(130));
    }

    @Test
    public void givenFourAProducts_thenTotalIsSpecialOfferPlusOneTotalling180() {
        assertThat(checkliteSolution.checklite("AAAA"), Matchers.is(180));
    }

    @Test
    public void givenFourAProductsAndOneB_thenTotalIs210() {
        assertThat(checkliteSolution.checklite("AAAAB"), Matchers.is(210));
    }

    @Test
    public void givenFourAProductsAndFourB_thenTotalIs255() {
        assertThat(checkliteSolution.checklite("AAAABBBB"), Matchers.is(270));
    }

    @Test
    public void givenFourAProductsAndFourBOutOfOrder_thenTotalIs255() {
        assertThat(checkliteSolution.checklite("ABABBABA"), Matchers.is(270));
    }

    @Test
    public void givenOneOFEachProductAtoD_totalIs115() {
        assertThat(checkliteSolution.checklite("ABCD"), Matchers.is(115));
    }

    @Test
    public void givenInvalidProductCodeInBasket_thenReturnError() {
        assertThat(checkliteSolution.checklite("BCXD"), Matchers.is(-1));
    }

    @Test
    public void givenTwoSpecialOffersX4YOnA_whenAddingSecondSpecialOffer_thenOfferIsApplied() {
        assertThat(checkliteSolution.checklite("AAAAA"), Matchers.is(200));
    }

    @Test
    public void givenTwoSpecialOffersX4YOnA_whenTwoOffersApply_thenChepestShouldBeApplied() {
        assertThat(checkliteSolution.checklite("AAAAAA"), Matchers.is(250));
    }

    @Test
    public void givenTwoEsAndOneB_thenTotalShouldBeForTwoEsOnly() {
        assertThat(checkliteSolution.checklite("EEB"), Matchers.is(80));
    }

    @Test
    public void givenFourEsAndTwoBs_thenTotalShouldBeForFourEsOnly() {
        assertThat(checkliteSolution.checklite("EEEEBB"), Matchers.is(160));
    }

    @Test
    public void givenFourEsAndOneB_thenTotalShouldBeForFourEsOnly() {
        assertThat(checkliteSolution.checklite("EEEEB"), Matchers.is(160));
    }

    @Test
    public void givenFourEsAndThreeBs_thenTotalShouldBeForFourEsAndOneB() {
        assertThat(checkliteSolution.checklite("EEEEBBB"), Matchers.is(190));
    }

    @Test
    public void givenEightAs_thenTotalShouldBeForFourEsAndOneB() {
        assertThat(checkliteSolution.checklite("AAAAAAAA"), Matchers.is(330));
    }

    @Test
    public void givenNineAs_thenTotalShouldBeForFourEsAndOneB() {
        assertThat(checkliteSolution.checklite("AAAAAAAAA"), Matchers.is(380));
    }

    @Test
    public void givenMix_thenTotalShouldBeForFourEsAndOneB() {
        assertThat(checkliteSolution.checklite("AAAAAEEBAAABB"), Matchers.is(380));

    }
}