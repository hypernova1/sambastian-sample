package org.sam.api.post;

import org.sam.server.annotation.component.Repository;
import org.sam.sqlexecutor.DataSource;
import org.sam.sqlexecutor.DefaultSqlExecutor;

import java.util.List;

/**
 * Created by melchor
 * Date: 2020/08/11
 * Time: 8:33 PM
 */
@Repository
public class PostRepository extends DefaultSqlExecutor<Post> {

    public PostRepository(DataSource dataSource) {
        super(dataSource);
    }

    public List<Post> findAll() {
        return this.selectAll("SELECT * FROM post");
    }

    public Post save(Post post) {
        int id = this.insert("INSERT INTO post (title, content, member_id, created_at, updated_at) VALUES (?, ?, ?, now(), now())", post.getTitle(), post.getContent(), post.getMemberId());
        post.setId(Integer.toUnsignedLong(id));
        return post;
    }

    public Post findById(Long id) {
        return this.selectOne("SELECT * FROM post WHERE id = ?", id);
    }

    public void delete(Long id) {
        this.execute("DELETE FROM post WHERE id = " + id);
    }
}
