package mn.ineg.app;

import com.giffing.wicket.spring.boot.context.scan.WicketHomePage;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import java.util.Arrays;
import java.util.List;

/**
 * Created by developer on 3/26/17.
 */
@WicketHomePage
public class HomePage extends WebPage {
    private static final String ZIPCODE = "ZIPCODE";
    private static final String PHONE = "PHONE";
    private static final List<String> TYPES = Arrays.asList(new String[]
            {
                    ZIPCODE, PHONE });
    public HomePage(final PageParameters parameters) {
        add(new FeedbackPanel("feedback"));
        final DropDownChoice<String> type = new DropDownChoice<String>("type", new Model<String>(ZIPCODE), TYPES);
        type.setRequired(true);

        final TextField<String> keywords = new TextField<String>("keywords", new Model<String>());
        keywords.setRequired(true);

        Form<?> form = new Form<Void>("form"){
            @Override
            protected void onSubmit() {
                info("Form successfully submitted");
            }
        };
        add(form);
        form.add(type);
        form.add(keywords);
    }
}