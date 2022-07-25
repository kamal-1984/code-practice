/*
 * 
 */
package com.upday.news.service;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.TestComponent;
import org.springframework.dao.DataIntegrityViolationException;

import com.upday.news.dataaccessobject.ArticleRepository;
import com.upday.news.datatransferobject.ArticleInputDTO;
import com.upday.news.domainobject.ArticleDO;
import com.upday.news.exception.ConstraintsViolationException;
import com.upday.news.exception.EntityNotFoundException;

// TODO: Auto-generated Javadoc
/**
 * The Class ArticleServiceImplTests.
 */
@TestComponent
public class ArticleServiceImplTests {
	
	/** The Article service impl. */
	@InjectMocks
	private ArticleServiceImpl articleServiceImpl;
	
	/** The article repository. */
	@Mock
	private ArticleRepository articleRepository;

	/**
	 * Test.
	 */
	@Before
	public void init() {
		MockitoAnnotations.openMocks(this);
	}
	
	/**
	 * Verify article create.
	 *
	 * @throws ConstraintsViolationException the constraints violation exception
	 */
	@Test
	public void verifyArticleCreate() throws ConstraintsViolationException {
		Mockito.when(this.articleRepository.save(Mockito.any(ArticleDO.class))).thenReturn(buildArticleDO());
		final ArticleDO articleDO = this.articleServiceImpl.create(new ArticleDO());
		assertEquals("author", articleDO.getAuthor());
		assertEquals("Header", articleDO.getHeader());
	}
	
	/**
	 * Verify article create when exception.
	 */
	@Test
	public void verifyArticleCreateWhenException(){
		Mockito.when(this.articleRepository.save(Mockito.any(ArticleDO.class))).thenThrow(DataIntegrityViolationException.class);
		ArticleDO articleDO = null;
		try {
			articleDO = this.articleServiceImpl.create(new ArticleDO());
		} catch (final ConstraintsViolationException e) {
			assertEquals(e.getClass(), ConstraintsViolationException.class);
			assertNull(articleDO);
		}
	}
	
	/**
	 * Verify article update.
	 *
	 * @throws EntityNotFoundException the entity not found exception
	 */
	@Test
	public void verifyArticleUpdate() throws  EntityNotFoundException {
		final Optional<ArticleDO> value = Optional.of(buildArticleDO());
		Mockito.when(this.articleRepository.findById(Mockito.anyLong())).thenReturn(value);
		Mockito.when(this.articleRepository.save(Mockito.any(ArticleDO.class))).thenReturn(buildArticleDO());
		final ArticleDO articleDO = this.articleServiceImpl.update(new ArticleInputDTO(),123L);
		assertEquals("author", articleDO.getAuthor());
		assertEquals("Header", articleDO.getHeader());
	}
	
	/**
	 * Verify article create when exception.
	 */
	@Test
	public void verifyArticleUpdateWhenException(){
		Mockito.when(this.articleRepository.save(Mockito.any(ArticleDO.class))).thenThrow(DataIntegrityViolationException.class);
		ArticleDO articleDO = null;
		try {
			articleDO = this.articleServiceImpl.update(new ArticleInputDTO(),123L);
		} catch (final EntityNotFoundException e) {
			assertEquals(e.getClass(), EntityNotFoundException.class);
			assertNull(articleDO);
		}
	}
	
	/**
	 * Verify article delete.
	 *
	 * @throws EntityNotFoundException the entity not found exception
	 */
	@Test
	public void verifyArticleFindById() throws  EntityNotFoundException {
		final Optional<ArticleDO> value = Optional.of(buildArticleDO());
		Mockito.when(this.articleRepository.findById(Mockito.anyLong())).thenReturn(value);
		final ArticleDO articleDO = this.articleServiceImpl.findById(123L); 
		assertEquals("author", articleDO.getAuthor());
		assertEquals("Header", articleDO.getHeader());
	}
	
	/**
	 * Verify article find all by author.
	 *
	 * @throws EntityNotFoundException the entity not found exception
	 */
	@Test
	public void verifyArticleFindAllByAuthor() throws  EntityNotFoundException {
		Mockito.when(this.articleRepository.findByAuthorContainingIgnoreCase(Mockito.anyString())).thenReturn(getArticleList());
		final List<ArticleDO> articleDOList = this.articleServiceImpl.findAllByAuthor("author"); 
		assertEquals("author", articleDOList.get(0).getAuthor());
		assertEquals("Header", articleDOList.get(0).getHeader());
	}
	
	/**
	 * Verify article find all by keyword.
	 *
	 * @throws EntityNotFoundException the entity not found exception
	 */
	@Test
	public void verifyArticleFindAllByKeyword() throws  EntityNotFoundException {
		Mockito.when(this.articleRepository.findByKeywordsContainingIgnoreCase(Mockito.anyString())).thenReturn(getArticleList());
		final List<ArticleDO> articleDOList = this.articleServiceImpl.findAllByKeyword("first"); 
		assertEquals("author", articleDOList.get(0).getAuthor());
		assertEquals("Header", articleDOList.get(0).getHeader());
	}
	
	/**
	 * Builds the article DO.
	 *
	 * @return the article DO
	 */
	private ArticleDO buildArticleDO() {
		final ArticleDO articleDO = new ArticleDO();
		articleDO.setAuthor("author");
		articleDO.setHeader("Header");
		articleDO.setKeywords("keywords for first article");
		return articleDO;
	}
	/**
	 * Gets the article list.
	 *
	 * @return the article list
	 */
	private List<ArticleDO> getArticleList(){
		final List<ArticleDO> articleList = new ArrayList();
		articleList.add(buildArticleDO());
		return articleList;
	}
}
