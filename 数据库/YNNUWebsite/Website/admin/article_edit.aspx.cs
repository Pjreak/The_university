using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Website.admin
{
    public partial class article_edit : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if(!IsPostBack)
            {
                int article_id = Tool.Tool.RequestQstrInt("id");
                if (article_id != 0)
                {
                    using (var ctx = new Models.ynnuEntities())
                    {
                        DropDownListmenu.DataSource = ctx.menu.OrderBy(s => s.sort_id).ToList();
                        DropDownListmenu.DataBind();

                        var article = ctx.article.Where(s => s.id == article_id).FirstOrDefault();
                        if (article != null)
                        {
                            ViewState["article_id"] = article_id;

                            TextBoxtitle.Text  = article.title;
                            DropDownListmenu.SelectedValue = article.menu_id.ToString();
                            TextBoxwriter.Text = article.writer;
                            TextBoxContent.Text = article.text;

                        }
                    }
                }
            }
        }

        protected void ButtonSave_Click(object sender, EventArgs e)
        {
            int article_id = Tool.Tool.Obj2Int(ViewState["article_id"]);
            using (var ctx = new Models.ynnuEntities())
            {
                var article = ctx.article.Where(s => s.id == article_id).FirstOrDefault();
                if(article!=null)
                {
                    article.title = TextBoxtitle.Text.Trim();
                    article.menu_id = Tool.Tool.Obj2Int(DropDownListmenu.SelectedValue);
                    article.writer = TextBoxwriter.Text.Trim();
                    article.text = TextBoxContent.Text.Trim();


                    ctx.SaveChanges();

                    Response.Redirect("article_list.aspx");
                }
            }
        }
    }
}