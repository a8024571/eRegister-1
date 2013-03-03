class UrlMappings {

	static mappings = {
                "/classes"(controller:'classes', action:'index')
                name courseHome: "/classes/$courseCode" (controller:'classes', action:'courseHome')
                name classHome: "/classes/$courseCode/$classCode" (controller:'classes', action:'classHome')
                name sheetHome: "/classes/$courseCode/$classCode/$sheetCode" (controller:'classes', action:'sheetHome')

		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}

		"/"(view:"/index")
		"500"(view:'/error')

	}
}
