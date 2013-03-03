class UrlMappings {

	static mappings = {
                "/classes"(controller:'classes', action:'index')
                name courseHome: "/classes/$courseCode" (controller:'classes', action:'courseHome')
                name classHome: "/classes/$courseCode/$classCode" (controller:'classes', action:'classHome')
                name clsact: "/classes/$courseCode/$classCode/$action" ( controller:'classes' )

		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}

		"/"(view:"/index")
		"500"(view:'/error')

	}
}
