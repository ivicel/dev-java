package info.ivicel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class MainController {

    @Autowired
    private PostRepo postRepo;

    @GetMapping
    public ResponseEntity index() {

        List<Object> posts = postRepo.myFetchAll(null);
        //         findAll((root, query, cb) -> {
        //     query = cb.createQuery();
        //     query.multiselect(root, root.get("author"));
        //     Join<Post, User> join = root.join("author", JoinType.LEFT);
        //
        //
        //     return cb.equal(join.get("id"), root.get("author").get("id"));
        // });

        // List<Post> posts = postRepository.findAll();
        // System.out.println(posts);
        // System.out.println(posts.get(0).getAuthor());
        // return ResponseEntity.ok(posts);
        return ResponseEntity.ok(posts);
    }

    public static class WebResult {
        private int i;
        private String s;
        private Object object;

        public WebResult(int i, String s, Object object) {
            this.i = i;
            this.s = s;
            this.object = object;
        }

        public int getI() {
            return i;
        }

        public String getS() {
            return s;
        }

        public Object getObject() {
            return object;
        }
    }

    @GetMapping("/abc")
    public WebResult abc() {
        Post post = new Post();
        post.setBody("ajdfklsajf");
        List<Post> list = new ArrayList<>();
        list.add(post);

        Map<Object, Object> map = new HashMap<>();
        map.put("first", list.get(0));
        map.put("second", list);

        return new WebResult(200, "ok", map);
    }
}
