package com.zhangyingwei.miner.common.dao;

import java.util.List;
import org.springframework.stereotype.Component;
import com.zhangyingwei.miner.annotation.MyBatisRespository;
import com.zhangyingwei.miner.common.entity.PageInfo;
import com.zhangyingwei.miner.common.entity.Article;

@MyBatisRespository
@Component
public interface ArticleDao {
	
	public List<Article> queryArticle(PageInfo pageinfo);
	
	public Integer getCount();
	
	public Article queryArticleByPar(Article article);
	
	public void deleteArticle(String elink);
	
	public void saveArticle(Article article);
}
