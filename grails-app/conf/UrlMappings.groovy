class UrlMappings {

	static mappings = {
                "/classes"(controller:'classes', action:'index')
                "/classes/${courseCode}" (controller:'classes', action:'courseHome')
                "/classes/${courseCode}/${classCode}" (controller:'classes', action:'classHome')

		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}

		"/"(view:"/index")
		"500"(view:'/error')

	}
}
