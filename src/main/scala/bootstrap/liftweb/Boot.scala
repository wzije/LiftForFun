package bootstrap.liftweb

import net.liftweb.db.DB
import net.liftweb.http.{Req, Html5Properties, LiftRules}
import net.liftweb.sitemap.Loc.Hidden
import net.liftweb.sitemap.{Menu, SiteMap}
import net.liftweb.util.DefaultConnectionIdentifier
import org.jee.lift.config.DBConfigBasic

/**
 * A class that's instantiated early and run.  It allows the application
 * to modify lift's environment
 */

class Boot {
  def boot {
    // where to search snippet
    LiftRules.addToPackages("org.jee")


    /*connect database*/
    DB.defineConnectionManager(DefaultConnectionIdentifier, DBConfigBasic)

    // Build SiteMap
    def sitemap(): SiteMap = SiteMap(
      Menu.i("Home") / "index",
      Menu.i("Plain") / "plain",
      Menu.i("Scalajs") / "scalajs",
      Menu.i("List Posts") / "posts" / "posts/list",
      Menu.i("Create Posts") / "posts" / "posts/create",
      Menu.i("Edit Posts") / "posts" / "posts/edit" >> Hidden,
      Menu.i("View Posts") / "posts" / "posts/view" >> Hidden,
      Menu.i("Delete Posts") / "posts" / "posts/delete" >> Hidden
    )

    // Use HTML5 for rendering
    LiftRules.htmlProperties.default.set((r: Req) =>
      new Html5Properties(r.userAgent))
  }
}