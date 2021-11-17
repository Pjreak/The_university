using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Website.admin
{
    public partial class menu_add : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if(!IsPostBack)
            {
                DropDownListMenu.DataSource = Tool.menu.GetMenuList(null);
                DropDownListMenu.DataBind();

                ListItem item = new ListItem();
                item.Text = "顶级栏目";
                item.Value = "0";
                DropDownListMenu.Items.Insert(0, item);

            }
        }

        protected void ButtonSave_Click(object sender, EventArgs e)
        {
            using (var ctx = new Models.ynnuEntities())
            {
                var menu = new Models.menu();
                menu.id = ctx.menu.Select(s => s.id).DefaultIfEmpty().Max() + 1;
                menu.title = TextBoxtitle.Text.Trim();
                menu.sort_id =Tool.Tool.Obj2Int(TextBoxsort_id.Text.Trim());
                if(DropDownListMenu.SelectedValue=="0")
                {
                    menu.menu_id = null;
                }
                else
                {
                    menu.menu_id = Tool.Tool.Obj2Int(DropDownListMenu.SelectedValue);
                }
                ctx.menu.Add(menu);
                if (ctx.SaveChanges() > 0)
                {
                    Response.Redirect("menu_list.aspx");
                }
                else
                {
                    LabelAlert.Text = "添加失败";
                }
            }
        }
    }
}