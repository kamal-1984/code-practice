/*
 * 
 */
package com.upday.news.dataaccessobject;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.TestComponent;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.upday.news.domainobject.ArticleDO;

// TODO: Auto-generated Javadoc
/**
 * The Class ArticleRepositoryIntegrationTest.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@TestComponent
public class ArticleRepositoryIntegrationTests {

	 
 	/** The repository. */
		@InjectMocks
	    private ArticleRepository repository;
		
		/**
		 * Test.
		 */
		@Before
		public void test() {
			MockitoAnnotations.openMocks(this);
		}

	    /**
    	 * Verify all articles.
    	 *
    	 * @throws ParseException the parse exception
    	 */
    	@Test
	    public void verifyAllArticles() throws ParseException {
	        final List<ArticleDO> allArtiles = (List<ArticleDO>) repository.findAll();
	        assertEquals(3, allArtiles.size());
	    }

	    /**
    	 * Verify article withspecific keyword.
    	 *
    	 * @throws ParseException the parse exception
    	 */
    	@Test
	    public void verifyArticleWithspecificKeyword() throws ParseException {
	        final List<ArticleDO> result = repository.findByKeywordsContainingIgnoreCase("Colombo");
	        assertEquals(1, result.size());
	        assertTrue(result.get(0).getKeywords().toLowerCase().contains("colombo"));
	    }
    	
    	/**
	     * Verify article with invalid keyword.
	     *
	     * @throws ParseException the parse exception
	     */
	    @Test
	    public void verifyArticleWithInvalidKeyword() throws ParseException {
	        final List<ArticleDO> result = repository.findByKeywordsContainingIgnoreCase("invalid");
	        assertEquals(0, result.size());
	    }
	    
	    /**
    	 * Verify article with specific author.
    	 *
    	 * @throws ParseException the parse exception
    	 */
    	@Test
	    public void verifyArticleWithSpecificAuthor() throws ParseException {
	        final List<ArticleDO> result = repository.findByAuthorContainingIgnoreCase("Times");
	        assertEquals(1, result.size());
	        assertTrue(result.get(0).getAuthor().toLowerCase().contains("times"));
	    }
    	
    	/**
	     * Verify article with invalid keyword.
	     *
	     * @throws ParseException the parse exception
	     */
	    @Test
	    public void verifyArticleWithInvalidAuthor() throws ParseException {
	        final List<ArticleDO> result = repository.findByKeywordsContainingIgnoreCase("invalid");
	        assertEquals(0, result.size());
	    }
}
