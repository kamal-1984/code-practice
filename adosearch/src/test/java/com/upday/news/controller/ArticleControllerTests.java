/*
 * 
 */
package com.upday.news.controller;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.TestComponent;

import com.upday.news.datatransferobject.ArticleInputDTO;
import com.upday.news.datatransferobject.ArticleOutputDTO;
import com.upday.news.domainobject.ArticleDO;
import com.upday.news.exception.ConstraintsViolationException;
import com.upday.news.exception.EntityNotFoundException;
import com.upday.news.exception.InvalidDataException;
import com.upday.news.service.ArticleService;

// TODO: Auto-generated Javadoc
/**
 * The Class ArticleControllerTests.
 */
@TestComponent
public class ArticleControllerTests {
	
	/** The controller. */
	@InjectMocks
	private final ArticleController controller = new ArticleController();
	
	/** The service. */
	@Mock
	private ArticleService service;

	/**
	 * Test.
	 */
	@Before
	public void test() {
		MockitoAnnotations.openMocks(this);
	}
	
	/**
	 * Verify create article.
	 *
	 * @throws ConstraintsViolationException the constraints violation exception
	 * @throws InvalidDataException the invalid data exception
	 */
	@Test
	public void verifyCreateArticle() throws ConstraintsViolationException, InvalidDataException {
		Mockito.when(this.service.create(Mockito.any(ArticleDO.class))).thenReturn(buildArticleDO());
		final ArticleOutputDTO output = this.controller.saveArticle(buildArticleInputDTO());
		assertNotNull(output);
		assertEquals(output.getHeader(), "Austrian Grand prix 2022");
	}
	
	/**
	 * Builds the article input DTO.
	 *
	 * @return the article input DTO
	 */
	private ArticleInputDTO buildArticleInputDTO() {
		final ArticleInputDTO articleDTO = new ArticleInputDTO();
		articleDTO.setHeader("header");
		articleDTO.setText("text");
		articleDTO.setAuthor("author");
		return articleDTO;
	}

	/**
	 * Verify get article by id with exception.
	 */
	@Test
	public void verifyCreateArticleWithException()  {
		ArticleOutputDTO output = null;
		try {
			Mockito.when(this.service.create(Mockito.any(ArticleDO.class))).thenThrow( new ConstraintsViolationException("ConstraintsViolationException while creating a article:"));
			output = this.controller.saveArticle(new ArticleInputDTO());
		} catch (final ConstraintsViolationException | InvalidDataException e) {
			assertEquals(e.getClass(), InvalidDataException.class);
			assertNull(output);
		}
	}
	/**
	 * Verify get article by id.
	 *
	 * @throws EntityNotFoundException the entity not found exception
	 */
	@Test
	public void verifyGetArticleById() throws EntityNotFoundException {
		Mockito.when(this.service.findById(Mockito.any(Long.class))).thenReturn(buildArticleDO());
		final ArticleOutputDTO output = this.controller.getById(234L);
		assertNotNull(output);
		assertEquals(output.getHeader(), "Austrian Grand prix 2022");
	}
	
	/**
	 * Verify get article by id with exception.
	 */
	@Test
	public void verifyGetArticleByIdWithException()  {
		ArticleOutputDTO output = null;
		try {
			Mockito.when(this.service.findById(Mockito.any(Long.class))).thenThrow( new EntityNotFoundException("Could not find entity with id: "));
			output = this.controller.getById(234L);
		} catch (final EntityNotFoundException e) {
			assertEquals(e.getClass(), EntityNotFoundException.class);
			assertNull(output);
		}
	}
	
	/**
	 * Verify get article by id.
	 *
	 * @throws EntityNotFoundException the entity not found exception
	 * @throws InvalidDataException the invalid data exception
	 */
	@Test
	public void verifyGetAllByKeyword() throws EntityNotFoundException, InvalidDataException {
		Mockito.when(this.service.findAllByKeyword(Mockito.anyString())).thenReturn(getArticleList());
		final List<ArticleOutputDTO> output = this.controller.getAllByKeyword("Mick");
		assertNotNull(output);
		assertEquals(1, output.size());
		assertEquals(output.get(0).getHeader(), "Austrian Grand prix 2022");
	}
	
	/**
	 * Verify get article by id.
	 *
	 * @throws EntityNotFoundException the entity not found exception
	 * @throws InvalidDataException the invalid data exception
	 */
	@Test
	public void verifyGetAllByAuthor() throws EntityNotFoundException, InvalidDataException {
		Mockito.when(this.service.findAllByAuthor(Mockito.anyString())).thenReturn(getArticleList());
		final List<ArticleOutputDTO> output = this.controller.getAllByAuthor("Times");
		assertNotNull(output);
		assertEquals(1, output.size());
		assertEquals(output.get(0).getAuthor(), "Global Times");
	}
	
	/**
	 * Verify get all articles.
	 *
	 * @throws EntityNotFoundException the entity not found exception
	 */
	@Test
	public void verifyGetAllArticles() throws EntityNotFoundException {
		Mockito.when(this.service.getAllArticlesList()).thenReturn(getArticleList());
		final List<ArticleOutputDTO> output = this.controller.getAllArticles();
		assertNotNull(output);
		assertEquals(1, output.size());
		assertEquals(output.get(0).getAuthor(), "Global Times");
	}
	
	/**
	 * Builds the article DO.
	 *
	 * @return the article DO
	 */
	private ArticleDO buildArticleDO() {
		final ArticleDO articleDO = new ArticleDO();
		articleDO.setHeader("Austrian Grand prix 2022");
		articleDO.setAuthor("Global Times");
		articleDO.setKeywords("Mick Charles lecrec Max Verstappen Hamilton Redbull Mercedes");
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
