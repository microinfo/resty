package cn.dreampie.route.render;

import cn.dreampie.common.Render;
import cn.dreampie.common.http.HttpRequest;
import cn.dreampie.common.http.HttpResponse;
import cn.dreampie.common.util.HttpTyper;
import cn.dreampie.common.util.json.Jsoner;

/**
 * Created by ice on 14-12-29.
 *
 * @JsonerFiled(serialize=false)
 */
public class JsonRender extends Render {
  public void render(HttpRequest request, HttpResponse response, Object out) {
    response.setContentType(HttpTyper.ContentType.JSON.toString());
    if (out == null) {
      write(request, response, "");
    } else if (out instanceof String) {
      write(request, response, (String) out);
    } else {
      String json = Jsoner.toJSONString(out);
      write(request, response, json);
    }
  }
}
