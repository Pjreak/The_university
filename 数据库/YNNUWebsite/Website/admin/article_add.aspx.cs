using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Website.admin
{
    public partial class article_add : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if(!IsPostBack)
            {
                using (var ctx = new Models.ynnuEntities())
                {
                    DropDownListmenu.DataSource = ctx.menu.OrderBy(s => s.sort_id).ToList();
                    DropDownListmenu.DataBind();
                }
            }
        }

        protected void ButtonSave_Click(object sender, EventArgs e)
        {
            using (var ctx = new Models.ynnuEntities())
            {
                var article = new Models.article();
                article.id = ctx.article.Select(s => s.id).DefaultIfEmpty().Max() + 1;
                article.title = TextBoxtitle.Text.Trim();
                article.menu_id =Convert.ToInt32(DropDownListmenu.SelectedValue);
                article.writer = TextBoxwriter.Text.Trim();
                article.add_time = DateTime.Now;
                article.click = 0;
                article.text = TextBoxContent.Text;

                ctx.article.Add(article);
                if(ctx.SaveChanges()>0)
                {
                    LabelAlert.Text = "添加成功";
                }
                else
                {
                    LabelAlert.Text = "添加失败";
                }
            }
        }
    }
}